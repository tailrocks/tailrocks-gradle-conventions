plugins {
    java
    `kotlin-dsl`
    `maven-publish`
    `java-gradle-plugin`

    // https://plugins.gradle.org/plugin/com.gradle.plugin-publish
    id("com.gradle.plugin-publish") version "0.20.0"
}

group = "com.tailrocks.gradle"
version = "0.1.0"

val javaVersion = 17

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.3.0")
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
}

gradlePlugin {
    plugins {
        create("tailrocksIdeaPlugin") {
            id = "com.tailrocks.idea"
            implementationClass = "com.tailrocks.gradle.IdeaPlugin"
        }
        create("tailrocksJavaPlugin") {
            id = "com.tailrocks.java"
            implementationClass = "com.tailrocks.gradle.JavaPlugin"
        }
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
        }
        create("tailrocksKotlinPlugin") {
            id = "com.tailrocks.kotlin"
            implementationClass = "com.tailrocks.gradle.KotlinPlugin"
        }
        create("tailrocksMavenPublishPlugin") {
            id = "com.tailrocks.maven-publish"
            implementationClass = "com.tailrocks.gradle.MavenPublishPlugin"
        }
        create("tailrocksSigningPlugin") {
            id = "com.tailrocks.signing"
            implementationClass = "com.tailrocks.gradle.SigningPlugin"
        }
        create("tailrocksSpotlessPlugin") {
            id = "com.tailrocks.spotless"
            implementationClass = "com.tailrocks.gradle.SpotlessPlugin"
        }
        create("tailrocksVersionsPlugin") {
            id = "com.tailrocks.versions"
            implementationClass = "com.tailrocks.gradle.VersionsPlugin"
        }
    }
}
