import app.cash.turbine.test
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.play
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSolution() = runTest {
        val scope = CoroutineScope(UnconfinedTestDispatcher(testScheduler))
        val sharedFlow = getSharedFlowFromCold(scope, coldFlow)
        sharedFlow.test {
            
            play.forEach {
                val item = awaitItem()
                assertEquals(it, item)
            }
            cancel()
        }
    }
}