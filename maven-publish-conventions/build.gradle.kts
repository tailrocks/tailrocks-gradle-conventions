plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.3.0"

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

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
