import app.cash.turbine.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.tenamalin
import org.junit.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.time.Duration.Companion.milliseconds

class Test {
    @Test fun testSolution() = runTest {
        val reciter = RhymeReciter()
        reciter.startReciting(this)
        delay(200.milliseconds) // even though the first two items are emitted
        // already because of the replay the whole list will be replayed
        reciter.lines.test {
            tenamalin.forEach {
                assertEquals("Tenamalin items not correct", it, awaitItem())
            }
            cancelAndConsumeRemainingEvents()
        }
        reciter.stopReciting()
    }
}