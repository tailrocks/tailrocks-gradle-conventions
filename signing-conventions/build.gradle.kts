plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.2.1-SNAPSHOT"

gradlePlugin {
    plugins {
        create("tailrocksSigningPlugin") {
            id = "com.tailrocks.signing"
            implementationClass = "com.tailrocks.gradle.SigningPlugin"
            displayName = "Tailrocks Signing conventions"
            description = "Common Gradle Signing plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
    pluginTags = mapOf(
        "tailrocksSigningPlugin" to listOf("signing")
    )
}
