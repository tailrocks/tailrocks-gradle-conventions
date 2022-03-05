package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.plugins.signing.SigningExtension

class SigningPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(org.gradle.plugins.signing.SigningPlugin::class.java)

        val signingExtension = project.extensions.getByType(SigningExtension::class.java)
        val publishingExtension = project.extensions.getByType(PublishingExtension::class.java)

        signingExtension.apply {
            val key = System.getenv("SIGNING_KEY") ?: return@apply
            val password = System.getenv("SIGNING_PASSWORD") ?: return@apply

            useInMemoryPgpKeys(key, password)
            sign(publishingExtension.publications)
        }
    }

}
