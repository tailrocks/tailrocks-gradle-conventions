plugins {
    `kotlin-dsl`
    `maven-publish`

    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    id("com.diffplug.spotless") version "6.3.0"
}

group = "com.tailrocks.gradle"
version = "0.1.0"

dependencies {
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.3.0")
}

publishing {
    repositories {
        maven {
            name = "SonatypeOssSnapshots"
            setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots")
            credentials {
                username = System.getenv("OSSRH_USER") ?: return@credentials
                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
            }
        }
        maven {
            name = "SonatypeOssReleases"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
            credentials {
                username = System.getenv("OSSRH_USER") ?: return@credentials
                password = System.getenv("OSSRH_PASSWORD") ?: return@credentials
            }
        }
    }
}

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
}
