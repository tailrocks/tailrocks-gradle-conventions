plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.8.0"

gradlePlugin {
    plugins {
        create("tailrocksMavenPublishPlugin") {
            id = "com.tailrocks.maven-publish"
            implementationClass = "com.tailrocks.gradle.MavenPublishPlugin"
            displayName = "Tailrocks Maven Publish conventions"
            description = "Common Gradle Maven Publish plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "maven-publish")
        }
    }
}
