plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20" apply false
}

subprojects {
    if (name == "applications" || name == "components") return@subprojects

    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.slf4j:slf4j-api:2.0.7")
        implementation("org.slf4j:slf4j-simple:2.0.7")

        testImplementation(kotlin("test-junit"))
    }
}
