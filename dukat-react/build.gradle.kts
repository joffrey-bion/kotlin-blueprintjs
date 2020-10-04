plugins {
    kotlin("jvm") version "1.4.10"
    application
}

repositories {
    jcenter()
}

application {
    mainClassName = "MainKt"
    applicationDefaultJvmArgs = listOf("-Xmx4g")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.9")
    implementation("com.github.ajalt:clikt:2.8.0")
    implementation("com.beust:klaxon:5.4")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

val check = tasks.getByName<Task>("check")
val installDist = tasks.getByName<Sync>("installDist")

val copyDistToUsrLocal by tasks.registering(Copy::class) {
    from(installDist.destinationDir)
    into(file("/usr/local/${project.name}"))
    dependsOn(check, installDist)
}

val symlinkExecutable by tasks.registering(Exec::class) {
    commandLine = listOf(
        "ln",
        "-sf",
        "/usr/local/${project.name}/bin/${project.name}",
        "/usr/local/bin/${project.name}"
    )
    dependsOn(copyDistToUsrLocal)
}

task("deployOnLocalMac") {
    group = "distribution"
    dependsOn(symlinkExecutable, copyDistToUsrLocal)
}
