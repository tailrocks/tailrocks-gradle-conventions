plugins {
    `kotlin-dsl`
    id("tailrocks-conventions")
}

version = "0.6.0"

dependencies {
    // https://plugins.gradle.org/plugin/org.sonarqube
    implementation(libs.sonarqube.gradle.plugin)
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
