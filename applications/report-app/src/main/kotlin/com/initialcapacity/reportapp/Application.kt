package com.initialcapacity.reportapp

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.database.dataSource
import com.initialcapacity.stripe.StripeGateway
import com.initialcapacity.subscriptions.SubscriptionsGateway
import com.initialcapacity.subscriptions.SubscriptionsService
import com.stripe.Stripe
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing

fun Application.module(databaseUrl: String, stripeApiKey: String, stripeBaseURL: String) {
    Stripe.apiKey = stripeApiKey
    Stripe.overrideApiBase(stripeBaseURL)

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
            stripeBaseURL = optionalEnvironmentVariable("STRIPE_BASE_URL", "https://api.stripe.com")
        )
    }).start(wait = true)
}

fun optionalEnvironmentVariable(value: String, default: String): String {
    return System.getenv()[value] ?: default
}

fun requiredEnvironmentVariable(value: String): String {
    return System.getenv()[value] ?: throw RuntimeException("missing configuration: $value")
}
