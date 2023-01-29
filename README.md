# BlueprintJS for Kotlin/React

[![Github Build](https://img.shields.io/github/actions/workflow/status/joffrey-bion/kotlin-blueprintjs/ci.yml?branch=main&logo=github)](https://github.com/joffrey-bion/kotlin-blueprintjs/actions/workflows/ci.yml)
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

[![core version](https://img.shields.io/maven-central/v/org.hildan.blueprintjs/kotlin-blueprintjs-core.svg?label=kotlin-blueprintjs-core)](http://mvnrepository.com/artifact/org.hildan.blueprintjs/kotlin-blueprintjs-core) <br>
[![icons version](https://img.shields.io/badge/kotlin--blueprintjs--icons-v3.29.0--4-blue)](http://mvnrepository.com/artifact/org.hildan.blueprintjs/kotlin-blueprintjs-icons)

## Setup

These blueprintjs wrappers are published to Maven Central.
You can add them to your Gradle dependencies the usual way (you don't need to add transitive BlueprintJS NPM dependencies anymore):

```kotlin
implementation("org.hildan.blueprintjs:kotlin-blueprintjs-core:3.49.1-4")
implementation("org.hildan.blueprintjs:kotlin-blueprintjs-icons:3.29.0-4")
```
