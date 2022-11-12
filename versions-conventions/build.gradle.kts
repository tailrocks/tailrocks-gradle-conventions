plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.1.5-SNAPSHOT"

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.44.0")
}

gradlePlugin {
    plugins {
        create("tailrocksVersionsPlugin") {
            id = "com.tailrocks.versions"
            implementationClass = "com.tailrocks.gradle.VersionsPlugin"
            displayName = "Tailrocks Versions conventions"
            description = "Common Gradle Versions plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
    pluginTags = mapOf(
        "tailrocksVersionsPlugin" to listOf("versions")
    )
}
