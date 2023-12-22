package test.initialcapacity.stripe

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.database.dataSource
import com.initialcapacity.subscriptions.SubscriptionsGateway
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SubscriptionsGatewayTest {
    private val source = dataSource("jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev")
    private val template = DatabaseTemplate(source)

    @Before
    fun setUp() {
        template.execute("""delete from example""", {}, {})
    }

    @Test
    fun testSubscriptionService(){
        val gateway = SubscriptionsGateway(template)
        assertEquals(1, gateway.findAll().size)
    }
}
