plugins {
    id("org.jetbrains.kotlin.plugin.serialization")
}

group = "com.initialcapacity.worker"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":components:database-support"))

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
}

task<JavaExec>("run") {
    classpath = files(tasks.jar)
}

tasks {
    jar {
        manifest { attributes("Main-Class" to "com.initialcapacity.worker.ApplicationKt") }
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        from({
            configurations.runtimeClasspath.get()
                .filter { it.name.endsWith("jar") }
                .map(::zipTree)
        })
    }
}
