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

    implementation(kotlin("gradle-plugin", "1.9.0"))
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")

    implementation("org.hildan.gradle:gradle-kotlin-publish-plugin:1.3.0")
    implementation("ru.vyarus:gradle-github-info-plugin:2.0.0")
}
