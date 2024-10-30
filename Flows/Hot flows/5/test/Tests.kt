import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.tenamalin
import org.junit.Test
import kotlin.test.DefaultAsserter.assertEquals

class Tests {
    @Test
    fun testSolution() = runTest {
        val reciter = RhymeReciter()
        reciter.startReciting(this)
        reciter.lines.test {
            tenamalin.forEach {
                assertEquals("Tenamalin items not correct", it, awaitItem())
            }
            cancelAndConsumeRemainingEvents()
        }
        reciter.stopReciting()
    }
}