plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`

    id("com.gradle.plugin-publish")
}

version = "0.2.0"

dependencies {
    // https://plugins.gradle.org/plugin/org.sonarqube
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.4.1.3373")
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

gradlePlugin {
    website = "https://github.com/tailrocks/tailrocks-gradle-conventions"
    vcsUrl = "https://github.com/tailrocks/tailrocks-gradle-conventions.git"
}
