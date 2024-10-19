import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class Test {
    @Test fun testSolution() = runTest {
        rainFlow.test {
            assertEquals("Rain, rain, go away.", awaitItem())
            assertEquals("Come again another day.", awaitItem())
            awaitComplete()
        }
    }
}