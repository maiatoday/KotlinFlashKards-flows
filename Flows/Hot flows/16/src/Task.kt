import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import net.maiatoday.rhymes.sea
import kotlin.time.Duration.Companion.milliseconds

class SplashReciter(scope: CoroutineScope) {
    private val coldFlow = flow {
        sea.forEach { word ->
            emit(word)
            delay(100.milliseconds)
        }
    }
    val stateFlow = coldFlow.stateIn(scope, SharingStarted.Lazily, "")
}

fun main(): Unit = runBlocking {
    SplashReciter(this).stateFlow.collect { println(it) }
}
