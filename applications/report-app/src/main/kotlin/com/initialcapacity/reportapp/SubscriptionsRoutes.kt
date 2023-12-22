package com.initialcapacity.reportapp

import com.initialcapacity.subscriptions.SubscriptionsService
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.subscriptions(service: SubscriptionsService) {
    get("/") {
        val list = service.list()
        call.respondText("hi! found=${list.size} subscriptions")
    }
}
