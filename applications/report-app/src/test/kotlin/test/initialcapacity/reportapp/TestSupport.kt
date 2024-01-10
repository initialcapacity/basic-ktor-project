package test.initialcapacity.reportapp

import com.initialcapacity.reportapp.module
import com.stripe.Stripe
import io.ktor.server.testing.ApplicationTestBuilder
import io.ktor.server.testing.testApplication

fun testApp(block: suspend ApplicationTestBuilder.() -> Unit) {
    testApplication {
        application {
            module(
                databaseUrl = "jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev",
                stripeApiKey = "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx",
                useStripeMock = true
            )
        }
        block()
    }
}
