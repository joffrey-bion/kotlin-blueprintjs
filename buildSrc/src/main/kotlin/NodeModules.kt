package org.hildan.dukat

import com.beust.klaxon.Klaxon
import java.nio.file.Files
import java.nio.file.Path

fun findModuleTypeDeclarationsIndex(nodeModulesDirPath: Path, moduleName: String): Path {
    val moduleDirPath = nodeModulesDirPath.resolve(moduleName)
    val typesRelativePath = extractTypings(moduleDirPath.resolve("package.json"))
    val typesPath = moduleDirPath.resolve(typesRelativePath)
    if (!Files.exists(typesPath)) {
        error("Bad typings entry in package.json: $typesPath does not exist")
    }
    return typesPath
}

private fun extractTypings(packageJsonPath: Path): String {
    val modulePackageJson = Klaxon().parse<PackageJson>(packageJsonPath.toFile())!!
    return modulePackageJson.typesPath ?: error("No 'typings' nor 'types' entry in package.json")
}

private data class PackageJson(
    val types: String? = null,
    val typings: String? = null
) {
    val typesPath: String?
        get() = types ?: typings
}
