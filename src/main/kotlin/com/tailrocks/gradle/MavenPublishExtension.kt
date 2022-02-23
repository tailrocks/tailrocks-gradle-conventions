package com.tailrocks.gradle

import org.gradle.api.provider.Property

interface MavenPublishExtension {
    val message: Property<String>
    val greeter: Property<String>
}
