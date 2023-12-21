package com.initialcapacity.subscriptions

import com.initialcapacity.stripe.StripeGateway

class SubscriptionsService(val stripe: StripeGateway, val gateway: SubscriptionsGateway) {
    fun list(): List<Subscription> {
        gateway.findAll().map { Subscription(it.id, it.name) }
        val subscriptions = stripe.subscriptions()
        return subscriptions.map { Subscription(it.id, it.status) }
    }
}
