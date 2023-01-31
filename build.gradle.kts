plugins {
    id("org.jetbrains.dokka")
    id("org.hildan.github.changelog") version "1.12.1"
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("kotlin-blueprintjs-githubinfo")
}

description = "Kotlin wrappers for the BlueprintJS react library"

allprojects {
    group = "org.hildan.blueprintjs"

    repositories {
        mavenCentral()
    }
}

changelog {
    githubUser = github.user
    futureVersionTag = project.version.toString()
}

nexusPublishing {
    packageGroup.set("org.hildan")
    repositories {
        sonatype()
    }
}
