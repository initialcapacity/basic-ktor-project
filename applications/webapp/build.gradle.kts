plugins {
    id("io.ktor.plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.github.johnrengelman.shadow")
}

group = "com.initialcapacity.webapp"
version = "0.0.1"

application {
    mainClass.set("com.initialcapacity.webapp.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":components:database-support"))

    implementation("io.ktor:ktor-server-caching-headers")
    implementation("io.ktor:ktor-server-caching-headers-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-freemarker-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-sessions-jvm")
    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-status-pages")
    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-java")
    implementation("io.ktor:ktor-server-auth")
    implementation("io.ktor:ktor-server-auth-jvm")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")

    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.20")
}
