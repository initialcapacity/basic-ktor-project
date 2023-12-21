package test.initialcapacity.stripe

import com.initialcapacity.stripe.StripeGateway
import com.stripe.Stripe
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StripeSupportTest {
    @Before
    fun setUp() {
        Stripe.apiKey = "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx"
        Stripe.overrideApiBase("http://localhost:12111")
    }

    @Test
    fun testStripeSupport(){
        val support = StripeGateway()
        val list = support.subscriptions()
        assertEquals(1, list.size)
        assertEquals(1, support.requests.get())
    }
}
