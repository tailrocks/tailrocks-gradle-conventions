plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

gradlePlugin {
    plugins {
        create("tailrocksSigningPlugin") {
            id = "com.tailrocks.signing"
            implementationClass = "com.tailrocks.gradle.SigningPlugin"
            displayName = "Tailrocks Signing conventions"
            description = "Common Gradle Signing plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "signing")
        }
    }
}
