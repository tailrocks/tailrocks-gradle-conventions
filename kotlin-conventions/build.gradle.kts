plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.11.0"

dependencies {
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation(libs.kotlin.gradle.plugin)
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.allopen
    implementation(libs.kotlin.allopen)
}

gradlePlugin {
    plugins {
        create("tailrocksKotlinPlugin") {
            id = "com.tailrocks.kotlin"
            implementationClass = "com.tailrocks.gradle.KotlinPlugin"
            displayName = "Tailrocks Kotlin conventions"
            description = "Common Gradle Kotlin plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "kotlin")
        }
    }
}
