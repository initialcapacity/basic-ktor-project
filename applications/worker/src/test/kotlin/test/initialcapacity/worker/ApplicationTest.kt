package test.initialcapacity.worker

import com.initialcapacity.worker.Application
import org.junit.Test
import kotlin.test.assertTrue

class ApplicationTest {

    @Test
    fun starts() {
        assertTrue(Application().start())
    }
}
