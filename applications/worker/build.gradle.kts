plugins {
    id("application")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.github.johnrengelman.shadow")
}

group = "com.initialcapacity.worker"
version = "0.0.1"

application {
    mainClass.set("com.initialcapacity.worker.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":components:database-support"))
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.20")
}
