package com.tailrocks.gradle

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class SpotlessPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(com.diffplug.gradle.spotless.SpotlessPlugin::class.java)

        val spotlessExtension = project.extensions.getByType(SpotlessExtension::class.java)

        spotlessExtension.apply {
            java {
                removeUnusedImports()
                trimTrailingWhitespace()
                endWithNewline()
                targetExclude("**/generated/**")
            }
            kotlinGradle {
                ktlint()
            }
        }
    }

}
