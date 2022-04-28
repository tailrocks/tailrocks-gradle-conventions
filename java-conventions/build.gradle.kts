plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.1.5-SNAPSHOT"

gradlePlugin {
    plugins {
        create("tailrocksJavaPlugin") {
            id = "com.tailrocks.java"
            implementationClass = "com.tailrocks.gradle.JavaPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")

    (plugins) {
        "tailrocksJavaPlugin" {
            displayName = "Tailrocks Java conventions"
            description = "Common Gradle Java plugin conventions used by tailrocks projects."
            tags = listOf("java")
            version = project.version as String
        }
    }
}
