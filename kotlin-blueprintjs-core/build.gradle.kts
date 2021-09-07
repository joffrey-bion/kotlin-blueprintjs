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
                implementation(libs.kotlin.wrappers.react.base)
                implementation(libs.kotlin.wrappers.react.dom)

                api(npm("@blueprintjs/core", bpCoreVersion))
            }
        }
    }
}
