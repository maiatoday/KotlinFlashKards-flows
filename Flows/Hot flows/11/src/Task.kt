import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.play
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

val coldFlow = flow {
    println("~~~~ start emitting")
    play.forEach {
        println("~~~~ emitting $it")
        emit(it)
        delay(500.milliseconds)
    }
}

// convert the coldFLow to a shared flow
fun getSharedFlowFromCold(scope: CoroutineScope, flow: Flow<String>) =
    flow.shareIn(
        scope = scope,
        // start the shared flow when the first subscriber appears and stop when they disappear
        started = SharingStarted.WhileSubscribed(),
        replay = 1
    )

fun main() = runBlocking {

    val sharedDrink = getSharedFlowFromCold(this, coldFlow)
    println("MAIN: The flow is converted but it doesn't start emitting until someone collects")
    delay(1.seconds)

    // Collect from the sharedFlow in two different collectors
    val job1 = launch {
        sharedDrink.collect { value ->
            println("Collector 1: $value")
        }
    }

    val job2 = launch {
        sharedDrink.collect { value ->
            println("    Collector 2: $value")
        }
    }

    delay(3.seconds) // Keep the main coroutine alive to see the results
    job1.cancel()
    println("MAIN: Stop collector 1")
    println("MAIN: Collector 2 gets a few more lines")
    delay(1.seconds)
    job2.cancel()
    println("MAIN: No subscribers, flow should no longer emit")
    delay(5.seconds)
}