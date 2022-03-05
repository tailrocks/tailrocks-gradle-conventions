package com.tailrocks.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.withType

class JunitPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val isFailFast = System.getenv("GRADLE_FAIL_FAST") == null ||
                System.getenv("GRADLE_FAIL_FAST").toLowerCase() == "true"

        val isParallel = System.getenv("JUNIT_PARALLEL") == "true"

        project.tasks.withType<Test> {
            useJUnitPlatform()
            failFast = isFailFast
            if (isParallel) {
                systemProperties["junit.jupiter.execution.parallel.enabled"] = true
                systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
                systemProperties["junit.jupiter.execution.parallel.mode.classes.default"] = "concurrent"
            }
        }
    }

}
