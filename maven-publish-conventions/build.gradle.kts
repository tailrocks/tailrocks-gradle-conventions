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

gradlePlugin {
    plugins {
        create("tailrocksMavenPublishPlugin") {
            id = "com.tailrocks.maven-publish"
            implementationClass = "com.tailrocks.gradle.MavenPublishPlugin"
            displayName = "Tailrocks Maven Publish conventions"
            description = "Common Gradle Maven Publish plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "maven-publish")
        }
    }
}

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
