plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.7.0"

dependencies {
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation(libs.spotless.plugin.gradle)
}

gradlePlugin {
    plugins {
        create("tailrocksSpotlessPlugin") {
            id = "com.tailrocks.spotless"
            implementationClass = "com.tailrocks.gradle.SpotlessPlugin"
            displayName = "Tailrocks Spotless conventions"
            description = "Common Gradle Spotless plugin conventions used by tailrocks projects."
            version = project.version as String
            tags = listOf("conventions", "spotless")
        }
    }
}
