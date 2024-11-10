import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.drink
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        val sharedFlow  = getSharedFlowFromCold(this, coldFlow)
        sharedFlow.test {
            drink.forEach {
                assertEquals(it, awaitItem())
            }
        }
    }
}