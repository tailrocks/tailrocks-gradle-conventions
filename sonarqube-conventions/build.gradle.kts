import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.5.0"

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
    // https://plugins.gradle.org/plugin/org.sonarqube
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:7.0.1.6134")
}

gradlePlugin {
    plugins {
        create("tailrocksSonarqubePlugin") {
            id = "com.tailrocks.sonarqube"
            implementationClass = "com.tailrocks.gradle.SonarqubePlugin"
            displayName = "Tailrocks Sonarqube conventions"
            description = "Common Sonarqube plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "sonarqube")
        }
    }
}

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
