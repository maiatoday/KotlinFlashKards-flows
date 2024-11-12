import app.cash.turbine.test
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.sea
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test fun testSolution() = runTest {
        val scope = CoroutineScope(UnconfinedTestDispatcher(testScheduler))

        val splashReciter = SplashReciter(scope)
        splashReciter.stateFlow.test {
            sea.forEach {
                assertEquals(it, awaitItem())
                expectNoEvents()
            }
        }

    }
}