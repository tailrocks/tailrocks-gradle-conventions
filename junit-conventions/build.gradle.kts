plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

gradlePlugin {
    plugins {
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
            displayName = "Tailrocks JUnit conventions"
            description = "Common Gradle JUnit plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "junit")
        }
    }
}
