/*
 * Copyright 2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

class MavenPublishPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(org.gradle.api.publish.maven.plugins.MavenPublishPlugin::class.java)

        val projectLicenseName = project.properties["projectLicenseName"] as String?
        val projectLicenseUrl = project.properties["projectLicenseUrl"] as String?
        val projectScmUrl = project.properties["projectScmUrl"] as String?
        val projectScmConnection = project.properties["projectScmConnection"] as String?
        val projectScmDeveloperConnection = project.properties["projectScmDeveloperConnection"] as String?
        val projectIssueManagementUrl = project.properties["projectIssueManagementUrl"] as String?
        val projectPublishingRepositories = project.properties["projectPublishingRepositories"] as String?

        val publishingExtension = project.extensions.getByType(PublishingExtension::class.java)

        publishingExtension.apply {
            publications {
                create<MavenPublication>("mavenJava").apply {
                    from(project.components["java"])
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
            if (projectPublishingRepositories != null) {
                val names = projectPublishingRepositories.split(",")

                repositories {
                    if (names.contains("SonatypeOssSnapshots")) {
                        maven {
                            name = "SonatypeOssSnapshots"
                            setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots")
                            credentials {
                                username = System.getenv("OSSRH_USER") ?: return@credentials
                                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
                            }
                        }
                    }

                    if (names.contains("SonatypeOssReleases")) {
                        maven {
                            name = "SonatypeOssReleases"
                            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
                            credentials {
                                username = System.getenv("OSSRH_USER") ?: return@credentials
                                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
                            }
                        }
                    }

                    if (names.contains("ArtifactorySnapshots")) {
                        maven {
                            name = "ArtifactorySnapshots"
                            setUrl("${System.getenv("ARTIFACTORY_CONTEXT_URL")}/${System.getenv("ARTIFACTORY_SNAPSHOT_REPO_KEY")}")
                            credentials {
                                username = System.getenv("ARTIFACTORY_USERNAME") ?: return@credentials
                                password = System.getenv("ARTIFACTORY_PASSWORD") ?: return@credentials
                            }
                        }
                    }

                    if (names.contains("ArtifactoryReleases")) {
                        maven {
                            name = "ArtifactoryReleases"
                            setUrl("${System.getenv("ARTIFACTORY_CONTEXT_URL")}/${System.getenv("ARTIFACTORY_RELEASE_REPO_KEY")}")
                            credentials {
                                username = System.getenv("ARTIFACTORY_USERNAME") ?: return@credentials
                                password = System.getenv("ARTIFACTORY_PASSWORD") ?: return@credentials
                            }
                        }
                    }
                }
            }
        }
    }

}
