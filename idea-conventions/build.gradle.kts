plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

gradlePlugin {
    plugins {
        create("tailrocksIdeaPlugin") {
            id = "com.tailrocks.idea"
            implementationClass = "com.tailrocks.gradle.IdeaPlugin"
            displayName = "Tailrocks IDEA conventions"
            description = "Common Gradle IDEA plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "idea")
        }
    }
}
