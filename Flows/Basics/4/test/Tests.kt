import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        val expected = """
            A-tisket a-tasket
            A green and yellow basket
            I wrote a letter to my friend
            And on the way I dropped it,
            
        """.trimIndent()
        assertEquals(expected, getMessages())
    }
}