plugins {
    id("application")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.github.johnrengelman.shadow")
}

group = "com.initialcapacity.worker"
version = "0.0.1"

val kotlinVersion: String by project

application {
    mainClass.set("com.initialcapacity.worker.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":components:database-support"))

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
