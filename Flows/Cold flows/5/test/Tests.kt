import kotlinx.coroutines.test.runTest
import net.maiatoday.rhymes.nutTree
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.times

class Test {
    @Test
    fun testSolution() = runTest {
        val numberOfLoops = 3
        val duration = numberOfLoops * oneLoopDuration
        val collected = collectNutTree(this, duration)
        assertEquals(nutTree.subList(0, numberOfLoops), collected)
    }
}