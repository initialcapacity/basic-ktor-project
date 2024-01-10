package com.initialcapacity.reportapp

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.database.dataSource
import com.initialcapacity.stripe.StripeGateway
import com.initialcapacity.subscriptions.SubscriptionsGateway
import com.initialcapacity.subscriptions.SubscriptionsService
import com.stripe.Stripe
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

fun Application.module(databaseUrl: String, stripeApiKey: String, useStripeMock: Boolean) {
    if (useStripeMock) {
        Stripe.overrideApiBase("http://localhost:12111")
    }

    Stripe.apiKey = stripeApiKey

    val stripeSupport = StripeGateway()
    val template = DatabaseTemplate(dataSource(databaseUrl))
    val gateway = SubscriptionsGateway(template)
    val subscriptionsService = SubscriptionsService(stripeSupport, gateway)

    routing {
        subscriptions(subscriptionsService)
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = {
        module(
            databaseUrl = requiredEnvironmentVariable("DATABASE_URL"),
            stripeApiKey = requiredEnvironmentVariable("STRIPE_API_KEY"),
            useStripeMock = System.getenv("USE_STRIPE_MOCK") == "true"
        )
    }).start(wait = true)
}

fun requiredEnvironmentVariable(value: String): String {
    return System.getenv()[value] ?: throw RuntimeException("missing configuration: $value")
}
