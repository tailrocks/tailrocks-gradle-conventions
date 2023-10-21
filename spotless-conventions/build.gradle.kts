import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.5.1"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
        javaParameters = true
    }
    jvmTargetValidationMode.set(JvmTargetValidationMode.WARNING)
}

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
            tags = listOf("conventions", "spotless")
        }
    }
}

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
