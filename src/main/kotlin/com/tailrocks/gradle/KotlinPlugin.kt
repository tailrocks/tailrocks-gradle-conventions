package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

class KotlinPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(KotlinPlatformJvmPlugin::class.java)

        project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "16"
                javaParameters = true
            }
        }
    }

}
