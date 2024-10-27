import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() = runTest {
        val expected = listOf(
            "A-tisket a-tasket",
            "    See a pin and pick it up,",
            "A green and yellow basket",
            "    All the day you'll have good luck;",
            "I wrote a letter to my friend",
            "And on the way I dropped it,",
            "    See a pin and let it lay,",
            "    Bad luck you'll have all the day!",

        )
        assertEquals(expected, basketOfLuckMashup().toList())
    }
}
