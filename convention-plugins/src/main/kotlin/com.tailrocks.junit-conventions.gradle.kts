val isFailFast = System.getenv("GRADLE_FAIL_FAST") == null ||
        System.getenv("GRADLE_FAIL_FAST").toLowerCase() == "true"

val isParallel = System.getenv("JUNIT_PARALLEL") == "true"

tasks.withType<Test> {
    useJUnitPlatform()
    failFast = isFailFast
    if (isParallel) {
        systemProperties["junit.jupiter.execution.parallel.enabled"] = true
        systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
        systemProperties["junit.jupiter.execution.parallel.mode.classes.default"] = "concurrent"
    }
}
