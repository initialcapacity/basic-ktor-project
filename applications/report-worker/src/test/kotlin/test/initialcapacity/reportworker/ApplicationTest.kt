package test.initialcapacity.reportworker

import com.initialcapacity.reportworker.Application
import org.junit.Test
import kotlin.test.assertTrue

class ApplicationTest {

    @Test
    fun starts() {
        assertTrue(Application().start())
    }
}
