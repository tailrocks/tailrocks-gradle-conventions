import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.7.0"

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
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.allopen
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.9.21")
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

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
