plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.1.6-SNAPSHOT"

gradlePlugin {
    plugins {
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
            displayName = "Tailrocks JUnit conventions"
            description = "Common Gradle JUnit plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
    pluginTags = mapOf(
        "tailrocksJunitPlugin" to listOf("junit")
    )
}
