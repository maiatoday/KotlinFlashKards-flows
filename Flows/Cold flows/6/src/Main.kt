import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.dishSpoon
import kotlin.time.Duration.Companion.milliseconds

// Click into the Flow interface, the flow builder and the FlowCollector interface
// to see what the interface looks like.
val nurseryRhyme: Flow<String> = flow {
    for (line in dishSpoon) {
        emit(line)
        delay(10.milliseconds)
    }
}

fun main() = runBlocking {
    nurseryRhyme.collect {
        println(it)
    }
}