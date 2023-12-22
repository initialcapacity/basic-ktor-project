package test.initialcapacity.reportapp

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class SubscriptionsRoutesTest {
    @Test
    fun testList() = testApp {
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertContains(response.bodyAsText(), "hi!")
    }
}
