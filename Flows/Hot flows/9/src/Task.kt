import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.drink
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

val coldFlow = flow {
    println("start emitting")
    drink.forEach {
        emit(it)
        delay(500.milliseconds)
    }
}

// convert the coldFLow to a shared flow
fun getSharedFlowFromCold(scope: CoroutineScope, flow: Flow<String>) =
    flow.shareIn(
        scope = scope,
        started = SharingStarted.Eagerly, // start the sharing immediately and never stop
        replay = 1
    )

fun main() = runBlocking {

    val sharedDrink = getSharedFlowFromCold(this, coldFlow)
    println("The flow is converted it should have started emitting already")

    // Collect from the sharedFlow in two different collectors
    launch {
        sharedDrink.collect { value ->
            println("Collector 1: $value")
        }
    }

    launch {
        println("    Collector 2 starts in after a delay so it will miss the first value")
        delay(1.seconds) // Start collecting after 1 second
        sharedDrink.collect { value ->
            println("    Collector 2: $value")
        }
    }

    delay(3000) // Keep the main coroutine alive to see the results
}