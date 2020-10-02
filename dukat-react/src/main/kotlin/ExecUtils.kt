import java.util.concurrent.TimeUnit

fun exec(vararg arguments: String): List<String> {
    val file = createTempFile("output-lines")
    ProcessBuilder(*arguments)
        .redirectOutput(ProcessBuilder.Redirect.appendTo(file))
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .waitFor(60, TimeUnit.SECONDS)
    val lines = file.readLines()
    file.delete()
    return lines
}
