plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "com.tailrocks.gradle.conventions"
version = "1.0"

repositories {
    gradlePluginPortal()
}

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
    // https://plugins.gradle.org/plugin/org.sonarqube
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.3")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}
