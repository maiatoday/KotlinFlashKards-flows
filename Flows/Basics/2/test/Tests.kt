import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Test {
    @Test fun testSolution() = runTest {
        nurseryRhyme.test {
            assertEquals("Hey diddle diddle,", awaitItem())
            assertEquals("The cat and the fiddle,", awaitItem())
            assertEquals("The cow jumped over the moon;", awaitItem())
            assertEquals("The little dog laughed", awaitItem())
            assertEquals("        To see such sport,", awaitItem())
            assertEquals("And the dish ran away with the spoon.", awaitItem())
            awaitComplete()
        }
    }
}