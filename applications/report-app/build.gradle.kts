plugins {
    id("org.jetbrains.kotlin.plugin.serialization")
}

group = "com.initialcapacity.reportapp"

val ktorVersion: String by project
val stripeVersion: String by project
val postgresVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":components:database-support"))
    implementation(project(":components:stripe-support"))
    implementation(project(":components:subscriptions"))

    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-freemarker-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")

    implementation("com.stripe:stripe-java:$stripeVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
}

task<JavaExec>("run") {
    classpath = files(tasks.jar)
}

tasks {
    jar {
        manifest { attributes("Main-Class" to "com.initialcapacity.reportapp.ApplicationKt") }
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        from({
            configurations.runtimeClasspath.get()
                .filter { it.name.endsWith("jar") }
                .map(::zipTree)
        })
    }
}
