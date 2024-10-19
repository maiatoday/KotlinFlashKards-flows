import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.tenamalin
import org.junit.Test

class Test {
    @Test fun testSolution() = runTest {
        tenamalinRhyme.test {
            tenamalin.forEach {
                assertEquals(it, awaitItem())
            }
            awaitComplete()
        }
    }
}