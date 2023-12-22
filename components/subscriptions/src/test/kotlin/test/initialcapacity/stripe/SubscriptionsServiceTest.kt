package test.initialcapacity.stripe

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.database.dataSource
import com.initialcapacity.stripe.StripeGateway
import com.initialcapacity.subscriptions.SubscriptionsGateway
import com.initialcapacity.subscriptions.SubscriptionsService
import com.stripe.Stripe
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SubscriptionsServiceTest {
    private val source = dataSource("jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev")
    private val template = DatabaseTemplate(source)

    @Before
    fun setUp() {
        template.execute("""delete from example""", {}, {})
        Stripe.apiKey = "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx"
        Stripe.overrideApiBase("http://localhost:12111")
    }

    @Test
    fun testSubscriptionService(){
        val support = StripeGateway()
        val gateway = SubscriptionsGateway(template)
        val service = SubscriptionsService(support, gateway)
        assertEquals(1, service.list().size)
    }
}
