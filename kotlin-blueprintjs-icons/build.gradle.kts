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
                implementation(libs.kotlin.wrappers.react.base)
                implementation(libs.kotlin.wrappers.react.dom)

                api(npm("@blueprintjs/icons", bpIconsVersion))
            }
        }
    }
}
