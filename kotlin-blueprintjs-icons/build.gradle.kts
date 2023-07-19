plugins {
    kotlin("multiplatform")
    id("kotlin-blueprintjs-publish")
    id("io.github.sgrishchenko.karakum") version "1.0.0-alpha.20"
}

val bpIconsVersion = libs.versions.blueprintjs.icons.get()
version = "$bpIconsVersion-${rootProject.version}"
description = "Kotlin wrapper for the @blueprintjs/icons module"

kotlin {
    js {
        browser()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                api(npm("@blueprintjs/icons", bpIconsVersion))
            }
        }
    }
}
