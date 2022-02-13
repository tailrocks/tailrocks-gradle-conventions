plugins {
    `java-library`
    `maven-publish`
}

val projectLicenseName: String? by project
val projectLicenseUrl: String? by project
val projectScmUrl: String? by project
val projectScmConnection: String? by project
val projectScmDeveloperConnection: String? by project
val projectIssueManagementUrl: String? by project

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
                url.set(projectScmUrl)
                if (projectLicenseName != null || projectLicenseUrl != null) {
                    licenses {
                        license {
                            name.set(projectLicenseName)
                            url.set(projectLicenseUrl)
                            distribution.set("repo")
                        }
                    }
                }
                if (projectScmUrl != null || projectScmConnection != null || projectScmDeveloperConnection != null) {
                    scm {
                        url.set(projectScmUrl)
                        connection.set(projectScmConnection)
                        developerConnection.set(projectScmDeveloperConnection)
                    }
                }
                if (projectIssueManagementUrl != null) {
                    issueManagement {
                        url.set(projectIssueManagementUrl)
                    }
                }
            }
        }
    }
}
