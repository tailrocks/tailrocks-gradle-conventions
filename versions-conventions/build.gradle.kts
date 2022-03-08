plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
}

gradlePlugin {
    plugins {
        create("tailrocksVersionsPlugin") {
            id = "com.tailrocks.versions"
            implementationClass = "com.tailrocks.gradle.VersionsPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")

    (plugins) {
        "tailrocksVersionsPlugin" {
            displayName = "Tailrocks Versions conventions"
            description = "Common Gradle Versions plugin conventions used by tailrocks projects."
            tags = listOf("versions")
            version = project.version as String
        }
    }
}
