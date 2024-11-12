import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import net.maiatoday.rhymes.sea
import net.maiatoday.rhymes.year
import kotlin.time.Duration.Companion.milliseconds

class SplashReciter(scope: CoroutineScope) {
    val coldFlow = flow {
        sea.forEach { word ->
            emit(word)
            delay(100.milliseconds)
        }
    }
    val channelFlow = channelFlow {
        year.forEach { word ->
            send(word)
            delay(200.milliseconds)
        }
    }
}

fun main(): Unit = runBlocking {
    val reciter = SplashReciter(this)
    reciter.coldFlow.collect { println("cold $it") }
    reciter.channelFlow.collect { println("channel $it") }
}

