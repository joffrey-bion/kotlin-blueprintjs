plugins {
    kotlin("js") version "1.7.20" apply false
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("org.jetbrains.dokka") version "1.7.20"
    id("org.hildan.github.changelog") version "1.12.1"
}

description = "Kotlin wrappers for the BlueprintJS react library"

allprojects {
    apply(plugin = "org.jetbrains.dokka")

    group = "org.hildan.blueprintjs"

    repositories {
        mavenCentral()
    }
}

val Project.githubUser: String? get() = findProperty("githubUser") as String? ?: System.getenv("GITHUB_USER")
val githubSlug = "$githubUser/${rootProject.name}"
val githubRepoUrl = "https://github.com/$githubSlug"

changelog {
    githubUser = project.githubUser
    futureVersionTag = project.version.toString()
}

nexusPublishing {
    packageGroup.set("org.hildan")
    repositories {
        sonatype()
    }
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    val dokkaJar by tasks.creating(Jar::class) {
        archiveClassifier.set("javadoc")
        from(tasks.findByName("dokkaHtml"))
    }

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()

                    from(components["kotlin"])
                    artifact(tasks.getByName<Zip>("jsLegacySourcesJar"))
                    artifact(dokkaJar)

                    configurePomForMavenCentral(project)
                }
            }
        }

        signing {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
            sign(publishing.publications)
        }

        tasks["assemble"].dependsOn(tasks["dokkaHtml"])
    }
}

fun MavenPublication.configurePomForMavenCentral(project: Project) = pom {
    name.set(project.name)
    description.set(project.description)
    url.set(githubRepoUrl)
    licenses {
        license {
            name.set("The MIT License")
            url.set("https://opensource.org/licenses/MIT")
        }
    }
    developers {
        developer {
            id.set("joffrey-bion")
            name.set("Joffrey Bion")
            email.set("joffrey.bion@gmail.com")
        }
    }
    scm {
        connection.set("scm:git:$githubRepoUrl.git")
        developerConnection.set("scm:git:git@github.com:$githubSlug.git")
        url.set(githubRepoUrl)
    }
}
