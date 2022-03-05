package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType

class JavaPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(org.gradle.api.plugins.JavaPlugin::class.java)

        project.tasks.withType<JavaCompile> {
            options.compilerArgs.add("-parameters")
        }
    }

}
