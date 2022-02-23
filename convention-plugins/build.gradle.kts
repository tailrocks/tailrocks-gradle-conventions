plugins {
    `kotlin-dsl`
    `maven-publish`
    signing
}

description = "Common used conventions to simplify configurations for Gradle projects."

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.3.0")
}

val projectLicenseShortName: String by project
val projectLicenseName: String by project
val projectLicenseUrl: String by project
val projectScmUrl: String by project
val projectScmConnection: String by project
val projectScmDeveloperConnection: String by project
val projectIssueManagementUrl: String by project

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            versionMapping {
                allVariants {
                    fromResolutionResult()
                }
            }
            pom {
                // TODO temp fix: https://github.com/gradle/gradle/issues/10861
                withXml {
                    val root = asNode()
                    var nodes = root["dependencyManagement"] as groovy.util.NodeList
                    while (nodes.isNotEmpty()) {
                        root.remove(nodes.first() as groovy.util.Node)

                        nodes = root["dependencyManagement"] as groovy.util.NodeList
                    }
                }
                // @end temp fix
                name.set(project.name)
                description.set(project.description)
                url.set(projectScmUrl)
                licenses {
                    license {
                        name.set(projectLicenseName)
                        url.set(projectLicenseUrl)
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("donbeave")
                        name.set("Alexey Zhokhov")
                        email.set("alexey@zhokhov.com")
                    }
                }
                scm {
                    url.set(projectScmUrl)
                    connection.set(projectScmConnection)
                    developerConnection.set(projectScmDeveloperConnection)
                }
                issueManagement {
                    url.set(projectIssueManagementUrl)
                }
            }
        }
    }
    repositories {
        maven {
            name = "SonatypeOssSnapshots"
            setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots")
            credentials {
                username = System.getenv("OSSRH_USER") ?: return@credentials
                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
            }
        }
        maven {
            name = "SonatypeOssReleases"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
            credentials {
                username = System.getenv("OSSRH_USER") ?: return@credentials
                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
            }
        }
    }
}

signing {
    val key = System.getenv("SIGNING_KEY") ?: return@signing
    val password = System.getenv("SIGNING_PASSWORD") ?: return@signing
    val publishing: PublishingExtension by project

    useInMemoryPgpKeys(key, password)
    sign(publishing.publications)
}
