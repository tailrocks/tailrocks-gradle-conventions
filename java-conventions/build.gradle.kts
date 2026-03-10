plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

gradlePlugin {
    plugins {
        create("tailrocksJavaPlugin") {
            id = "com.tailrocks.java"
            implementationClass = "com.tailrocks.gradle.JavaPlugin"
            displayName = "Tailrocks Java conventions"
            description = "Common Gradle Java plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "java")
        }
    }
}
