import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.tenamalin
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        val rhymeLastWord = RhymeLastWord()
        rhymeLastWord.startReciting(this)
        rhymeLastWord.word.test {
            assertEquals("", awaitItem())
            for (word in tenamalin) {
                assertEquals(word, awaitItem())
            }
            expectNoEvents()
        }
    }
}