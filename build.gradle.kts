plugins {
    kotlin("jvm") version "1.9.20"
    id("io.ktor.plugin") version "2.3.4" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20" apply false
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false

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

        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.20")
    }
}
