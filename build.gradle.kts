plugins {
    java
}

val javaVersion = 17

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

allprojects {
    group = "com.tailrocks.gradle"
    version = "0.1.0"
}

subprojects {
    apply(plugin = "java")

    java {
        withJavadocJar()
        withSourcesJar()
    }
}
