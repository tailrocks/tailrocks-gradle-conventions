apply(from = File(settingsDir, "gradle/repositoriesSettings.gradle.kts"))

rootProject.name = "gradle-conventions"

include(
    "base-conventions",
    "kotlin-conventions",
    "spotless-conventions",
    "versions-conventions"
)
