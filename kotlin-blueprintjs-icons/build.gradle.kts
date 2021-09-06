plugins {
    kotlin("js")
}

val bpIconsVersion = libs.versions.blueprintjs.icons.get()
version = "$bpIconsVersion-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/icons module"

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

                api(npm("@blueprintjs/core", bpIconsVersion))
            }
        }
    }
}
