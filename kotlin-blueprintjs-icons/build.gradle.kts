plugins {
    kotlin("multiplatform")
    id("kotlin-blueprintjs.publish")
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
        val jsMain by getting {
            dependencies {
                api(npm("@blueprintjs/icons", bpIconsVersion))
            }
        }
    }
}
