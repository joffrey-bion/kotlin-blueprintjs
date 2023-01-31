plugins {
    kotlin("js")
    id("kotlin-blueprintjs-publish")
}

val bpIconsVersion = libs.versions.blueprintjs.icons.get()
version = "$bpIconsVersion-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/icons module"

kotlin {
    js {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                api(npm("@blueprintjs/icons", bpIconsVersion))
            }
        }
    }
}
