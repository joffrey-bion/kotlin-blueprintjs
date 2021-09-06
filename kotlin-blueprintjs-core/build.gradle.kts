plugins {
    kotlin("js")
}

val bpCoreVersion = libs.versions.blueprintjs.core.get()
version = "$bpCoreVersion-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/core module"

kotlin {
    js(BOTH) {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                val kotlinWrappers = libs.versions.kotlin.wrappers.get()
                val kotlinReact = "${libs.versions.react.get()}-$kotlinWrappers"
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReact")
                implementation(npm("react", libs.versions.react.get()))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReact")
                implementation(npm("react-dom", libs.versions.react.get()))

                api(npm("@blueprintjs/core", bpCoreVersion))
            }
        }
    }
}
