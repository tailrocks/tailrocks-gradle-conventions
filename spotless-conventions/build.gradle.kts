plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

dependencies {
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.3.0")
}

gradlePlugin {
    plugins {
        create("tailrocksSpotlessPlugin") {
            id = "com.tailrocks.spotless"
            implementationClass = "com.tailrocks.gradle.SpotlessPlugin"
        }
    }
}
