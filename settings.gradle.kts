pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()

        // uncomment if you need to use snapshot versions
        //maven("https://oss.sonatype.org/content/repositories/snapshots")
        //maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
        //maven("https://oss.jfrog.org/oss-snapshot-local")
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

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
