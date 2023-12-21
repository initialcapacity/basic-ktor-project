plugins {
    id("org.jetbrains.kotlin.plugin.serialization")
}

val kotlinVersion: String by project
val ktorVersion: String by project
val stripeVersion: String by project
val postgresVersion: String by project
val hikariVersion: String by project

dependencies {
    implementation(project(":components:database-support"))
    implementation(project(":components:stripe-support"))
    implementation(project(":components:subscriptions"))

    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-freemarker-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")

    implementation("com.stripe:stripe-java:$stripeVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("com.zaxxer:HikariCP:$hikariVersion")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
