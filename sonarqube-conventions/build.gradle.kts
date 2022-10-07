plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.0.1-SNAPSHOT"

dependencies {
    // https://plugins.gradle.org/plugin/org.sonarqube
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.4.0.2513")
}

gradlePlugin {
    plugins {
        create("tailrocksSonarqubePlugin") {
            id = "com.tailrocks.sonarqube"
            implementationClass = "com.tailrocks.gradle.SonarqubePlugin"
            displayName = "Tailrocks Sonarqube conventions"
            description = "Common Sonarqube plugin conventions used by tailrocks projects."
            version = project.version as String
        }
    }
}

pluginBundle {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
    tags = listOf("conventions")
    pluginTags = mapOf(
        "tailrocksSonarqubePlugin" to listOf("sonarqube")
    )
}
