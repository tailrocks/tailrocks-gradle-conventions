package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class MavenPublishPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("greeting", MavenPublishExtension::class.java)
        project.task("hello") {
            doLast {
                println("${extension.message.get()} from ${extension.greeter.get()}")
            }
        }
    }

}
