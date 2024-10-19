import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.nutTree
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

val oneLoopDuration = 100.milliseconds
val nutTreeFlow = flow {
    nutTree.forEach {
        emit(it)
        delay(oneLoopDuration)
    }
}

suspend fun collectNutTree(scope: CoroutineScope, duration: Duration): List<String> {
    val collected = mutableListOf<String>()
    val job = scope.launch {
        nutTreeFlow.collect {
            collected.add(it)
        }
    }
    delay(duration)
    job.cancel()
    return collected
}

fun main() = runBlocking {
    // adjust the time to see how it stops after different duration and emits more of the rhyme
    collectNutTree(this, 400.milliseconds)
        .forEach { println(it) }
}