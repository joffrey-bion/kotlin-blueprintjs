plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    implementation(gradleApi())
    implementation(gradleKotlinDsl())

    // we're not using the kotlin("gradle-plugin", ...) shortcut because dependabot doesn't understand it
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.10")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")

    implementation("org.hildan.gradle:gradle-kotlin-publish-plugin:1.3.0")
    implementation("ru.vyarus:gradle-github-info-plugin:2.0.0")
}
