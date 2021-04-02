plugins {
    kotlin("js")
}

kotlin {
    js {
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

                api(npm("@blueprintjs/core", "3.36.0"))
            }
        }
    }
}
