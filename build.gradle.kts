plugins {
    id("org.jetbrains.dokka")
    id("org.hildan.github.changelog") version "2.2.0"
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    id("kotlin-blueprintjs.githubinfo")
}

description = "Kotlin wrappers for the BlueprintJS react library"

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
