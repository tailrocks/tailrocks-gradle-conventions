plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

gradlePlugin {
    plugins {
        create("tailrocksIdeaPlugin") {
            id = "com.tailrocks.idea"
            implementationClass = "com.tailrocks.gradle.IdeaPlugin"
        }
        create("tailrocksJavaPlugin") {
            id = "com.tailrocks.java"
            implementationClass = "com.tailrocks.gradle.JavaPlugin"
        }
        create("tailrocksJunitPlugin") {
            id = "com.tailrocks.junit"
            implementationClass = "com.tailrocks.gradle.JunitPlugin"
        }
        create("tailrocksMavenPublishPlugin") {
            id = "com.tailrocks.maven-publish"
            implementationClass = "com.tailrocks.gradle.MavenPublishPlugin"
        }
        create("tailrocksSigningPlugin") {
            id = "com.tailrocks.signing"
            implementationClass = "com.tailrocks.gradle.SigningPlugin"
        }
    }
}
