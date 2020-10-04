import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

data class TransformTask(
    val sourcePath: Path,
    val targetPath: Path,
    val sourceFiles: List<File>
)

fun File.recursivePathMappings(targetDir: Path, predicate: (File) -> Boolean): List<TransformTask> {
    val thisPath = Paths.get(absolutePath)
    return recursiveDirs(predicate).map {
        val relativePath = thisPath.relativize(it.absolutePath)
        TransformTask(
            sourcePath = it.absolutePath,
            targetPath = targetDir.resolve(relativePath),
            sourceFiles = it.files
        )
    }
}

private data class Directory(
    val absolutePath: Path,
    val files: List<File>
)

private fun File.recursiveDirs(predicate: (File) -> Boolean): List<Directory> {
    val children: Array<File> = listFiles() ?: return emptyList()

    val (dirs, files) = children.partition { it.isDirectory }

    val childDirs = dirs.flatMap { it.recursiveDirs(predicate) }

    val absPath = Paths.get(this.absolutePath)
    return if (files.isEmpty()) childDirs else childDirs + Directory(absPath, files.filter(predicate))
}

fun File.replaceContents(transform: (String) -> String) {
    writeText(transform(readText()))
}
