package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.plugins.ide.idea.model.IdeaModel

class IdeaPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(org.gradle.plugins.ide.idea.IdeaPlugin::class.java)
        val ideaModel = project.extensions.getByType(IdeaModel::class.java)

        ideaModel.module.isDownloadJavadoc = false
        ideaModel.module.isDownloadSources = false
    }

}
