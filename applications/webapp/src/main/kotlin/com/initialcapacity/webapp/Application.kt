package com.initialcapacity.webapp

import com.initialcapacity.database.configureDatabases
import com.initialcapacity.web.basic
import com.initialcapacity.web.requiredEnvironmentVariable
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    basic(
        configureDatabases(requiredEnvironmentVariable("DATABASE_URL")),
        requiredEnvironmentVariable("STRIPE_API_KEY")
    )
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}
