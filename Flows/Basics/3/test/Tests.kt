import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        shortRhyme.test {
            assertEquals("Rain, rain, go away.", awaitItem())
            assertEquals("Come again another day.", awaitItem())
            awaitComplete()
        }
    }
}