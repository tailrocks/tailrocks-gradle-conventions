plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation(libs.gradle.versions.plugin)
}

gradlePlugin {
    plugins {
        create("tailrocksVersionsPlugin") {
            id = "com.tailrocks.versions"
            implementationClass = "com.tailrocks.gradle.VersionsPlugin"
            displayName = "Tailrocks Versions conventions"
            description = "Common Gradle Versions plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "versions")
        }
    }
}
