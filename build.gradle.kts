plugins {
    java

    // https://plugins.gradle.org/plugin/com.gradle.plugin-publish
    id("com.gradle.plugin-publish") version "0.20.0"

    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    id("com.diffplug.spotless") version "6.3.0"
}

val javaVersion = 17

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

allprojects {
    group = "com.tailrocks.gradle"
    version = "0.1.0"

    apply(plugin = "com.diffplug.spotless")

    spotless {
        java {
            removeUnusedImports()
            trimTrailingWhitespace()
            endWithNewline()
            targetExclude("**/generated/**")
        }
        kotlinGradle {
            ktlint()
        }
        java {
            licenseHeaderFile("$rootDir/gradle/licenseHeader.txt")
        }
        kotlin {
            licenseHeaderFile("$rootDir/gradle/licenseHeader.txt")
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
}
