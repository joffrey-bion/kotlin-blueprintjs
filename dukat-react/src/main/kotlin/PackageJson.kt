import com.beust.klaxon.Klaxon
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

data class PackageJson(
    val types: String? = null,
    val typings: String? = null,
) {
    companion object {
        fun parse(file: File): PackageJson = Klaxon().parse<PackageJson>(file)!!
    }
}

val PackageJson.typesPath: Path?
    get() = (types ?: typings)?.let { Paths.get(it) }
