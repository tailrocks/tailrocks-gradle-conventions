import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.6.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}

project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.set(listOf("-Xjsr305=strict"))
        jvmTarget.set(JvmTarget.JVM_21)
        javaParameters.set(true)
    }
    jvmTargetValidationMode.set(JvmTargetValidationMode.WARNING)
}

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.50.0")
}

gradlePlugin {
    plugins {
        create("tailrocksVersionsPlugin") {
            id = "com.tailrocks.versions"
            implementationClass = "com.tailrocks.gradle.VersionsPlugin"
            displayName = "Tailrocks Versions conventions"
            description = "Common Gradle Versions plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "versions")
        }
    }
}

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
