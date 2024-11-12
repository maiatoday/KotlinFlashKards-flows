import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.year
import kotlin.time.Duration.Companion.milliseconds

class SplashReciter(scope: CoroutineScope) {
    private val coldFlow = flow {
        year.forEach { word ->
            emit(word)
            delay(100.milliseconds)
        }
    }
    val sharedFlow = coldFlow.shareIn(scope, SharingStarted.Lazily)
    val channelFlow = channelFlow {
        year.forEach { word ->
            send(word)
            delay(200.milliseconds)
        }
    }
}

fun main(): Unit = runBlocking {
    val reciter = SplashReciter(this)
    launch {
        reciter.sharedFlow.collect { println("subscriber 1 $it") }
    }
    launch {
        reciter.sharedFlow.collect { println("subscriber 2 $it") }
    }
    launch {
        reciter.channelFlow.collect { println("channel $it") }
    }
}
