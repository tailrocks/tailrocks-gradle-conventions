import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.4.0"

kotlin {
    jvmToolchain(21)
}

project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "20"
        javaParameters = true
    }
    jvmTargetValidationMode.set(JvmTargetValidationMode.WARNING)
}

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

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
