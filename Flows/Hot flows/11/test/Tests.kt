import app.cash.turbine.test
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.play
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() = runTest {
        val sharedFlow = getSharedFlowFromCold(this, coldFlow)
        sharedFlow.test {
            
            play.forEach {
                val item = awaitItem()
                assertEquals(it, item)
            }
            cancel()
        }
    }
}