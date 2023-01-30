plugins {
    kotlin("js")
}

val bpCoreVersion = libs.versions.blueprintjs.core.get()
version = "$bpCoreVersion-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/core module"

kotlin {
    js {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                api(project.dependencies.platform(libs.kotlin.wrappers.bom))
                api(libs.kotlin.wrappers.react.base)
                api(libs.kotlin.wrappers.react.dom)

                api(npm("@blueprintjs/core", bpCoreVersion))
            }
        }
    }
}
