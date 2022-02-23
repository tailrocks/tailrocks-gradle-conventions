package com.tailrocks.gradle

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

class VersionsPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(com.github.benmanes.gradle.versions.VersionsPlugin::class.java)

        project.tasks.withType<DependencyUpdatesTask> {
            resolutionStrategy {
                componentSelection {
                    all {
                        if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
                            reject("Release candidate")
                        }
                    }
                }
            }
        }
    }

    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }

}
