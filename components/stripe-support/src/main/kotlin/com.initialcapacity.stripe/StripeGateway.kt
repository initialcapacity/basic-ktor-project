package com.initialcapacity.stripe

import com.stripe.model.Subscription
import java.util.concurrent.atomic.AtomicInteger

class StripeGateway(val requests: AtomicInteger = AtomicInteger()) {

    fun subscriptions(): List<Subscription> {
        return measure {
            Subscription.list(emptyMap()).data
        }
    }

    private fun <T> measure(function: () -> T): T {
        val response = function()
        requests.incrementAndGet()
        return response
    }
}