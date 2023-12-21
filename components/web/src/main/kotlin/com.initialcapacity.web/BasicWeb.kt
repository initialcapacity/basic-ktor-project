package com.initialcapacity.web

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.stripe.StripeGateway
import com.initialcapacity.subscriptions.SubscriptionsGateway
import com.initialcapacity.subscriptions.SubscriptionsService
import com.stripe.Stripe
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import javax.sql.DataSource

fun Application.basic(dataSource: DataSource, stripeKey: String) {
    Stripe.apiKey = stripeKey

    val stripeSupport = StripeGateway()
    val template = DatabaseTemplate(dataSource)
    val gateway = SubscriptionsGateway(template)
    val subscription = SubscriptionsService(stripeSupport, gateway)

    routing {
        get("/") {
            val list = subscription.list()
            call.respondText("hi! found=${list.size} subscriptions")
        }
    }
}

fun requiredEnvironmentVariable(value: String): String {
    return System.getenv().get(value) ?: throw RuntimeException("missing configuration: $value")
}