package com.initialcapacity.subscriptions

import com.initialcapacity.database.DatabaseTemplate

class SubscriptionsGateway(val template: DatabaseTemplate) {
    fun findAll(): List<SubscriptionRecord> {
        return template.queryList("select gen_random_uuid(), 'all-in'", {}, {
            SubscriptionRecord(it.getString(1), it.getString(2))
        })
    }
}