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
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.withType

class JunitPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val isFailFast = System.getenv("TAILROCKS_GRADLE_FAIL_FAST") != null &&
                System.getenv("TAILROCKS_GRADLE_FAIL_FAST").lowercase() == "true"

        val isParallel = System.getenv("TAILROCKS_GRADLE_JUNIT_PARALLEL") == "true"

        project.tasks.withType<Test> {
            useJUnitPlatform()
            failFast = isFailFast
            if (isParallel) {
                systemProperties["junit.jupiter.execution.parallel.enabled"] = true
                systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
                systemProperties["junit.jupiter.execution.parallel.mode.classes.default"] = "concurrent"
            }

            systemProperties["junit.jupiter.testmethod.order.default"] =
                "org.junit.jupiter.api.MethodOrderer\$MethodName"
            systemProperties["junit.jupiter.testclass.order.default"] =
                "org.junit.jupiter.api.ClassOrderer\$ClassName"
        }
    }

}
