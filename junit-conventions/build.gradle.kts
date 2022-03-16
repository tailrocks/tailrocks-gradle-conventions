plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.1.4"

gradlePlugin {
    plugins {
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")

    (plugins) {
        "tailrocksJunitPlugin" {
            displayName = "Tailrocks JUnit conventions"
            description = "Common Gradle JUnit plugin conventions used by tailrocks projects."
            tags = listOf("junit")
            version = project.version as String
        }
    }
}
