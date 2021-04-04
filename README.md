# BlueprintJS for Kotlin/React

[![Maven central version](https://img.shields.io/maven-central/v/org.hildan.blueprintjs/kotlin-blueprintjs-core.svg)](http://mvnrepository.com/artifact/org.hildan.blueprintjs/kotlin-blueprintjs-core)
[![Github Build](https://img.shields.io/github/workflow/status/joffrey-bion/kotlin-blueprintjs/CI%20Build?label=build&logo=github)](https://github.com/joffrey-bion/kotlin-blueprintjs/actions?query=workflow%3A%22CI+Build%22)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/joffrey-bion/kotlin-blueprintjs/blob/main/LICENSE)

Kotlin wrappers for Palantir's [BlueprintJS](https://blueprintjs.com/) React components library.

## Usage

### RBuilder extensions

For each blueprintjs component, some `RBuilder` extension functions are defined with the prefix `bp` (e.g. `RBuilder.bpButton()`).
This makes it more convenient to use in `kotlin-react`.

### Icons module

The icons module wrapper is not mandatory to use icons, because you can use simple strings to refer to icons.
Only the `@blueprintjs/icons` module is necessary to actually bring the icons, but not the wrapper.

The wrapper module only contains the `IconNames` object declaring all icon name constants.
It allows to refer to icons in a type-safe way to avoid mistakes.

## Versioning

The version of each wrapper module is composed of the wrapped module version followed by a dash `-` and the version of
this wrapper library.

For example: `3.42.0-1` is the version `1` of the module wrapping `@blueprintjs/core` version `3.42.0`

## Setup

These blueprintjs wrappers are published to Maven Central.
However, Kotlin react wrappers have been moved to Space maven repositories (due to Bintray shutting down), 
so make sure you have the following repositories declared:

```kotlin
repositories {
    mavenCentral()
    // for kotlin-wrappers resolutions
    maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
    // for kotlinx-html (dependency of kotlin-react-dom)
    maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}
```

Then add the dependencies on the BlueprintJS modules you need, along with the corresponding Kotlin wrapper:

```kotlin
kotlin {
    js {
        browser()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                val bpWrapperVersion = "1"
                val bpCoreVersion = "3.42.0"
                val bpIconsVersion = "3.26.0"
                implementation("org.hildan.blueprintjs:kotlin-blueprintjs-core:$bpCoreVersion-$bpWrapperVersion")
                implementation("org.hildan.blueprintjs:kotlin-blueprintjs-icons:$bpIconsVersion-$bpWrapperVersion")
                implementation(npm("@blueprintjs/core", bpCoreVersion))
                implementation(npm("@blueprintjs/icons", bpIconsVersion))
            }
        }
    }
}
```