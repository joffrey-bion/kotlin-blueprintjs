package org.hildan.dukat

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.nio.file.Path
import java.util.concurrent.TimeUnit

open class GenerateExternalsTask : DefaultTask() {

    @Input
    lateinit var moduleName: String

    @Input
    lateinit var packageName: String

    @InputDirectory
    var nodeModulesDir: Path = project.buildDir.resolve("js/node_modules").toPath()

    @OutputDirectory
    var outputDir: Path = project.rootDir.resolve("src/main/generated").toPath()

    @TaskAction
    fun generate() {
        val indexTs = findModuleTypeDeclarationsIndex(nodeModulesDir, moduleName)

        println("Running dukat on $indexTs...")
        val ktFiles = runDukat(listOf(indexTs))

        println("Post-processing ${ktFiles.size} Kotlin files...")
        val moduleInFilename = moduleName.replace('/', '_')
        ktFiles.filter { it.toString().endsWith("module_$moduleInFilename.kt") }.forEach(::postProcessKotlinFile)

        println("Done.")
    }

    private fun runDukat(tsFiles: List<Path>): List<Path> {
        val filePaths = tsFiles.map { f -> f.toString() }.toTypedArray()
        val dukatBinary = if ("windows" in System.getProperty("os.name").toLowerCase()) "dukat.cmd" else "dukat"
        val lines = exec(dukatBinary, "-m", moduleName, "-d", outputDir.toString(), *filePaths)
        return lines.map { outputDir.resolve(it) }
    }

    private fun postProcessKotlinFile(ktFilePath: Path) {
        val file = ktFilePath.toFile()
        val contents = file.readText() //
            .addModuleAndPackage() //
            .fixDukatOutput() //
        file.writeText(contents)
    }

    private fun String.addModuleAndPackage(): String {
        if ("package " in this) {
            return this
        }
        val header = "@file:JsModule(\"$moduleName\")\npackage $packageName\n\n"
        return if ("@file:" in this) {
            replace(Regex("""(@file:.*\s*)+""")) { m -> "${m.value}\n$header" }
        } else {
            header + this
        }
    }
}

private fun exec(vararg arguments: String): List<String> {
    val file = createTempFile("output-lines")
    ProcessBuilder(*arguments).redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectOutput(ProcessBuilder.Redirect.appendTo(file))
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor(60, TimeUnit.SECONDS)
    val lines = file.readLines()
    file.delete()
    return lines
}
