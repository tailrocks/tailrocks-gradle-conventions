apply(from = File(settingsDir, "gradle/repositoriesSettings.gradle.kts"))

rootProject.name = "gradle-conventions"

include(
    "idea-conventions",
    "java-conventions",
    "junit-conventions",
    "kotlin-conventions",
    "maven-publish-conventions",
    "signing-conventions",
    "sonarqube-conventions",
    "spotless-conventions",
    "versions-conventions"
)
