plugins {
    kotlin("js")
}

version = "${Versions.bpIcons}-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/icons module"

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

                api(npm("@blueprintjs/icons", Versions.bpIcons))
            }
        }
    }
}
