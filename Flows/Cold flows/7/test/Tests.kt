import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() = runTest {
        val expected = listOf(
            "A-tisket a-tasket",
            "    If wishes were horses,",
            "A green and yellow basket",
            "    Beggars would ride;",
            "I wrote a letter to my friend",
            "And on the way I dropped it,",
            "    If turnips were watches,",
            "    I would wear one by my side.",
        )
        assertEquals(expected, basketOfWishesMashup().toList())
    }
}