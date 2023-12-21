package test.initialcapacity.webapp

import com.initialcapacity.webapp.basic
import com.initialcapacity.webapp.module
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun test() = testApplication {
        application {
            basic("jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev")
        }
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("hi!", response.bodyAsText())
    }
}
