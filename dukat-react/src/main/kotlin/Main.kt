import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.output.CliktHelpFormatter
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.defaultLazy
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.defaultLazy
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun main(args: Array<String>) = RootCmd.subcommands(Generate).main(args)

object RootCmd : NoOpCliktCommand(name = "dukreact") {
    init {
        context {
            helpFormatter = CliktHelpFormatter(showDefaultValues = true, showRequiredTag = true)
        }
    }
}

object Generate : CliktCommand(name = "generate", help = "Generate Kotlin from TS declarations") {

    private val moduleName by option("-m",
        help = "Use this value as @file:JsModule annotation value whenever such annotation occurs") //
        .default("@blueprintjs/core") // TODO remove this default

    private val packageName by option("-p", help = "Package name for the generated files") //
        .default("com.palantir.blueprintjs") // TODO remove this default

    private val outputDir by option("-d", help = "Overrides the directory in which to generate the new key classes") //
        .file(canBeFile = false, canBeDir = true, mustBeWritable = true) //
        .defaultLazy { Paths.get("kotlin-blueprintjs/src/main/kotlin").toFile() } // TODO change to src/main/kotlin

    private val outputDirPath: Path by lazy { Paths.get(outputDir.absolutePath) }

    private val nodeModulesDir by argument(
        name = "NODE_MODULES_DIR",
        help = "The node_modules directory containing the TS files to convert",
    ).file(mustExist = true, canBeFile = false, canBeDir = true, mustBeReadable = true) //
        .defaultLazy { Paths.get("build/js/node_modules").toFile() }

    private val nodeModulesDirPath: Path by lazy { Paths.get(nodeModulesDir.absolutePath) }

    override fun run() = catchAndPrintErrors {
        val indexTs = findModuleTypeDeclarationsIndex()

        val ktFiles = step("Running dukat on $indexTs...") {
            runDukat(listOf(indexTs))
        }

        step("Post-processing ${ktFiles.size} Kotlin files...") {
            val moduleInFilename = moduleName.replace('/', '_')
            ktFiles.filter { it.toString().endsWith("module_$moduleInFilename.kt") }.forEach(::postProcessKotlinFile)
        }
    }

    private fun findModuleTypeDeclarationsIndex(): Path {
        val moduleDirPath = nodeModulesDirPath.resolve(moduleName)
        val modulePackageJson = PackageJson.parse(moduleDirPath.resolve("package.json").toFile())
        val typesRelativePath = modulePackageJson.typesPath ?: error("No 'typings' nor 'types' entry in package.json")
        val typesPath = moduleDirPath.resolve(typesRelativePath)
        if (!Files.exists(typesPath)) {
            error("Bad typings entry in package.json: $typesPath does not exist")
        }
        return typesPath
    }

    private fun runDukat(tsFiles: List<Path>): List<Path> {
        val filePaths = tsFiles.map { f -> f.toString() }.toTypedArray()
        val lines = exec("cmd", "/c", "dukat", "-m", moduleName, "-d", outputDir.toString(), *filePaths)
        return lines.map { outputDirPath.resolve(it) }
    }

    private fun postProcessKotlinFile(ktFilePath: Path) {
        ktFilePath.toFile().replaceContents {
            it.addModuleAndPackage().fixConstructorTypeParameter().fixInitializedValues().fixPartials()
        }
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

    // https://github.com/Kotlin/dukat/issues/414
    private fun String.fixConstructorTypeParameter(): String {
        // class FileInput(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IFileInputProps>
        // class Drawer(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IDrawerProps>
        // class Icon(props: P = definedExternally, context: Any = definedExternally) : AbstractPureComponent2__1<IIconProps>
        // class Button(props: P = definedExternally, context: Any = definedExternally) : AbstractButton<ButtonHTMLAttributes<HTMLButtonElement>> {
        return replace(
            Regex("""class ([^)]+)\(props: P = definedExternally, context: Any = definedExternally\)\s*:\s*AbstractPureComponent2__1<([^/>]+(/\*[^*]+\*/)?)>"""),
            "class $1(props: $2 = definedExternally, context: Any = definedExternally): AbstractPureComponent2__1<$2>"
        ).replace(
            Regex("""class ([^)]+)\(props: P = definedExternally, context: Any = definedExternally\)\s*:\s*AbstractPureComponent2__2<([^,]+)\s*(,\s*[^,]+\s*)?>"""),
            "class $1(props: $2 = definedExternally, context: Any = definedExternally): AbstractPureComponent2__2<$2$3>"
        ).replace(
            Regex("""class ([^)]+)\(props: P = definedExternally, context: Any = definedExternally\)\s*:\s*AbstractButton<([^/>]+(/\*[^*]+\*/)?)>"""),
            "class $1(props: IButtonProps = definedExternally, context: Any = definedExternally): AbstractButton<$2>"
        )
    }

    // https://github.com/Kotlin/dukat/issues/415
    private fun String.fixInitializedValues(): String {
        // var SIZE_SMALL: Any = 20
        // var SIZE_SMALL: Any = "360px"
        return replace(Regex("""(va[rl])\s+(\w+)\s*:\s*(\w+)\s*=\s*((\d+)|("[^"]*"))"""),
            "$1 $2: $3 = definedExternally")
    }

    // https://github.com/Kotlin/dukat/issues/416
    private fun String.fixPartials(): String {
        // these interfaces only contains nullable properties anyway, so there is no need for their -Partial version
        return replace("""IPropsPartial""", "IProps")
            .replace("IIntentPropsPartial", "IIntentProps")
            .replace("IPopoverSharedPropsPartial", "IPopoverSharedProps")
    }

    private fun catchAndPrintErrors(block: suspend CoroutineScope.() -> Unit) {
        val result = runCatching { runBlocking { block() } }
        val exception = result.exceptionOrNull()
        if (exception != null) {
            System.err.println(exception.message)
            exception.printStackTrace()
        }
    }
}

fun File.replaceContents(transform: (String) -> String) {
    writeText(transform(readText()))
}
