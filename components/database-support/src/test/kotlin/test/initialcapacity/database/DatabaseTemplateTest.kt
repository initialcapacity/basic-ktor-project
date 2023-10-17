package test.initialcapacity.database

import com.initialcapacity.database.DatabaseTemplate
import com.initialcapacity.database.configureDatabases
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class DatabaseTemplateTest {
    val source = configureDatabases("jdbc:postgresql://localhost/example_test?user=initialdev&password=initialdev")
    val template = DatabaseTemplate(source)

    @Before
    fun before() {
        template.execute("""delete from example""", {}, {})
    }

    @Test
    fun testInsert() {
        val created = template.execute("""insert into example (name) values (?) returning name""",
            { it.setString(1, "phil") },
            { it.getString(1) }
        )
        assertEquals("phil", created)
    }

    @Test
    fun testQuery() {
        source.connection.use { it.prepareStatement("insert into example (name) values ('phil')").execute() }
        val found = template.query("""select name from example where name = ?""",
            { it.setString(1, "phil") },
            { it.getString(1) }
        )
        assertEquals("phil", found)
    }

    @Test
    fun testQueryList() {
        source.connection.use { it.prepareStatement("insert into example (name) values ('phil'), ('jim')").execute() }
        val found = template.queryList("""select name from example""", {},
            { it.getString(1) }
        )
        assertEquals(2, found.size)
        assertEquals("phil", found.first())
    }
}
