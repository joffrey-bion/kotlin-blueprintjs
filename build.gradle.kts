plugins {
    kotlin("js") version Versions.kotlin apply false
}

allprojects {
    group = "org.hildan.blueprintjs"

    repositories {
        mavenCentral()
        // for kotlin-wrappers resolutions
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
        // for kotlinx-html (dependency of kotlin-react-dom)
        maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    }
}
