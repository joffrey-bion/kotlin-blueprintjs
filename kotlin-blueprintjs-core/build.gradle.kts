plugins {
    kotlin("js")
}

version = "${Versions.bpCore}-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/core module"

kotlin {
    js(BOTH) {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                implementation("org.jetbrains:kotlin-react:${Versions.kotlinReact}")
                implementation(npm("react", Versions.react))
                implementation("org.jetbrains:kotlin-react-dom:${Versions.kotlinReact}")
                implementation(npm("react-dom", Versions.react))

                api(npm("@blueprintjs/core", Versions.bpCore))
            }
        }
    }
}
