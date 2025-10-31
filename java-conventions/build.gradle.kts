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

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
