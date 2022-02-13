plugins {
    id("com.diffplug.spotless")
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
