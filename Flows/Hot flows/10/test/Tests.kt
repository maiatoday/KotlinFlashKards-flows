import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.drink
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runBlocking {
        val sharedFlow  = getSharedFlowFromCold(this, coldFlow)
        sharedFlow.test {
            drink.forEach {
                assertEquals(it, awaitItem())
            }
        }
    }
}