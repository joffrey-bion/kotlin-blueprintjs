const val ANSI_RESET = "\u001B[0m"
const val ANSI_BLACK = "\u001B[30m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_PURPLE = "\u001B[35m"
const val ANSI_CYAN = "\u001B[36m"
const val ANSI_WHITE = "\u001B[37m"

inline fun <T> step(message: String, block: () -> T): T {
    print(message)
    val result = runCatching { block() }
    when {
        result.isSuccess -> printlnGreen("OK")
        result.isFailure -> printlnRed("FAILED")
    }
    return result.getOrThrow()
}

fun printlnGreen(message: String) = printlnColor(message, ANSI_GREEN)
fun printlnRed(message: String) = printlnColor(message, ANSI_RED)

private fun printlnColor(message: String, ansiColor: String) = println("$ansiColor$message$ANSI_RESET")
