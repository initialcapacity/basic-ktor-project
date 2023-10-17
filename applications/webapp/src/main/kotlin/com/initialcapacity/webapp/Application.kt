package com.initialcapacity.webapp

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.basic() {
    routing {
        get("/") {
            call.respondText("hi!")
        }
    }
}

fun Application.module() {
    basic()
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}
