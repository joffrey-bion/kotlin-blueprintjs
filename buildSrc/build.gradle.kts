plugins {
    kotlin("jvm") version "1.4.32"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.beust:klaxon:5.4")
}
