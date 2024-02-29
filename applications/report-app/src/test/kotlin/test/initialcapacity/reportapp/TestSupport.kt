package test.initialcapacity.reportapp

import com.initialcapacity.reportapp.module
import com.stripe.Stripe
import io.ktor.server.testing.ApplicationTestBuilder
import io.ktor.server.testing.testApplication

fun testApp(block: suspend ApplicationTestBuilder.() -> Unit) {
    Stripe.overrideApiBase("http://localhost:12111")

    testApplication {
        application {
            module(
                databaseUrl = "jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev",
                stripeApiKey = "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx",
                "http://localhost:12111"
            )
        }
        block()
    }
}
