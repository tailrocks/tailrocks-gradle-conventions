plugins {
    java

    // https://plugins.gradle.org/plugin/com.gradle.plugin-publish
    id("com.gradle.plugin-publish") version "1.0.0" apply false

    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    id("com.diffplug.spotless") version "6.9.0"
}

val javaVersion = 17

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

allprojects {
    group = "com.tailrocks.gradle"

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
