plugins {
    java

    // https://plugins.gradle.org/plugin/com.gradle.plugin-publish
    id("com.gradle.plugin-publish") version "1.2.1" apply false

    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    id("com.diffplug.spotless") version "6.22.0"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
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
