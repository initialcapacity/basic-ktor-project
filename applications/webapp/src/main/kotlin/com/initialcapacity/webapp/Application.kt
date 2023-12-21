package com.initialcapacity.webapp

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.basic(databaseUrl: String) {
    routing {
        get("/") {
            call.respondText("hi!")
        }
    }
}

fun Application.module() {
    val databaseUrl = requiredEnvironmentVariable("DATABASE_URL")
    basic(databaseUrl)
}

fun requiredEnvironmentVariable(value: String): String {
    return System.getenv().get(value) ?: throw RuntimeException("missing configuration: $value")
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}
