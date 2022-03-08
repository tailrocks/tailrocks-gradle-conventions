plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

gradlePlugin {
    plugins {
        create("tailrocksIdeaPlugin") {
            id = "com.tailrocks.idea"
            implementationClass = "com.tailrocks.gradle.IdeaPlugin"
        }
        create("tailrocksJavaPlugin") {
            id = "com.tailrocks.java"
            implementationClass = "com.tailrocks.gradle.JavaPlugin"
        }
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
        }
        create("tailrocksMavenPublishPlugin") {
            id = "com.tailrocks.maven-publish"
            implementationClass = "com.tailrocks.gradle.MavenPublishPlugin"
        }
        create("tailrocksSigningPlugin") {
            id = "com.tailrocks.signing"
            implementationClass = "com.tailrocks.gradle.SigningPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")

    (plugins) {
        "tailrocksIdeaPlugin" {
            displayName = "Tailrocks IDEA conventions"
            description = "Common Gradle IDEA plugin conventions used by tailrocks projects."
            tags = listOf("idea")
            version = project.version as String
        }

        "tailrocksJavaPlugin" {
            displayName = "Tailrocks Java conventions"
            description = "Common Gradle Java plugin conventions used by tailrocks projects."
            tags = listOf("java")
            version = project.version as String
        }

        "tailrocksJunitPlugin" {
            displayName = "Tailrocks JUnit conventions"
            description = "Common Gradle JUnit plugin conventions used by tailrocks projects."
            tags = listOf("junit")
            version = project.version as String
        }

        "tailrocksMavenPublishPlugin" {
            displayName = "Tailrocks Maven Publish conventions"
            description = "Common Gradle Maven Publish plugin conventions used by tailrocks projects."
            tags = listOf("maven", "publish")
            version = project.version as String
        }

        "tailrocksSigningPlugin" {
            displayName = "Tailrocks Signing conventions"
            description = "Common Gradle Signing plugin conventions used by tailrocks projects."
            tags = listOf("signing")
            version = project.version as String
        }
    }
}
