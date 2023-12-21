package test.initialcapacity.webapp

import com.initialcapacity.database.configureDatabases
import com.initialcapacity.web.basic
import com.stripe.Stripe
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.junit.Before
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ApplicationTest {

    @Before
    fun setUp() {
        Stripe.apiKey = "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx"
        Stripe.overrideApiBase("http://localhost:12111")
    }

    @Test
    fun test() = testApplication {
        application {
            basic(
                configureDatabases("jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev"),
                "sk_test_xxxxxxxxxxxxxxxxxxxxxxxx"
            )
        }
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertContains(response.bodyAsText(), "hi!")
    }
}
