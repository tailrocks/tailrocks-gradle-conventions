plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.3.0-SNAPSHOT"

dependencies {
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")
}

gradlePlugin {
    plugins {
        create("tailrocksSpotlessPlugin") {
            id = "com.tailrocks.spotless"
            implementationClass = "com.tailrocks.gradle.SpotlessPlugin"
            displayName = "Tailrocks Spotless conventions"
            description = "Common Gradle Spotless plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
