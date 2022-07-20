plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.1.4-SNAPSHOT"

dependencies {
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
}

gradlePlugin {
    plugins {
        create("tailrocksKotlinPlugin") {
            id = "com.tailrocks.kotlin"
            implementationClass = "com.tailrocks.gradle.KotlinPlugin"
            displayName = "Tailrocks Kotlin conventions"
            description = "Common Gradle Kotlin plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
    pluginTags = mapOf(
        "tailrocksKotlinPlugin" to listOf("kotlin")
    )
}
