import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() = runTest {
        val expected = listOf(
            "See a pin and pick it up,",
            "    If wishes were horses,",
            "All the day you'll have good luck;",
            "    Beggars would ride;",
            "See a pin and let it lay,",
            "Bad luck you'll have all the day!",
            "    If turnips were watches,",
            "    I would wear one by my side.",
        )
        assertEquals(expected, luckyWishMashup().toList())
    }
}


