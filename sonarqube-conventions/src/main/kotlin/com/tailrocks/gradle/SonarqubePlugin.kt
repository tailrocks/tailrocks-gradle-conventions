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

class SonarqubePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply(org.sonarqube.gradle.SonarQubePlugin::class.java)

        val model = project.extensions.getByType(org.sonarqube.gradle.SonarQubeExtension::class.java)
        model.properties {
            property("sonar.sourceEncoding", "UTF-8")
            property("sonar.verbose", true)
            property("sonar.host.url", System.getenv("SONAR_HOST_URL"))
            property("sonar.login", System.getenv("SONAR_LOGIN"))
            property("sonar.projectVersion", System.getenv("SONAR_PROJECT_VERSION") ?: "")
            if (
                System.getenv("CI_COMMIT_REF_NAME") != "master" ||
                System.getenv("CI_COMMIT_REF_NAME") != "main"
            ) {
                property("sonar.pullrequest.key", System.getenv("CI_EXTERNAL_PULL_REQUEST_IID"))
                property("sonar.pullrequest.branch", System.getenv("CI_EXTERNAL_PULL_REQUEST_SOURCE_BRANCH_NAME"))
                property("sonar.pullrequest.base", System.getenv("CI_EXTERNAL_PULL_REQUEST_TARGET_BRANCH_NAME"))
                property("sonar.scm.revision", System.getenv("CI_EXTERNAL_PULL_REQUEST_SOURCE_BRANCH_SHA"))
                property("sonar.pullrequest.provider", System.getenv("SONAR_PULLREQUEST_PROVIDER"))
            }
            property(
                "sonar.coverage.jacoco.xmlReportPaths",
                System.getProperty("coverage.jacoco.xmlReportPaths", "${project.rootDir}/result.xml")
            )
        }
    }
}
