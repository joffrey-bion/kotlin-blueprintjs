plugins {
    kotlin("js")
}

version = "${Versions.bpSelect}-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/select module"

kotlin {
    js(BOTH) {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                implementation(project(":kotlin-blueprintjs-core"))

                implementation("org.jetbrains:kotlin-react:${Versions.kotlinReact}")
                implementation(npm("react", Versions.react))
                implementation("org.jetbrains:kotlin-react-dom:${Versions.kotlinReact}")
                implementation(npm("react-dom", Versions.react))

                api(npm("@blueprintjs/select", Versions.bpSelect))
            }
        }
    }
}
