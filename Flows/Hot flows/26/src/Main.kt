import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import net.maiatoday.rhymes.sea
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class SplashReciter(scope: CoroutineScope) {
    private fun flow(duration: Duration, tag: String) = flow {
        sea.forEach { word ->
            println("$tag $word")
            emit(word)
            delay(duration)
        }
    }

    val stateFlow = flow(100.milliseconds, "fromState").stateIn(scope, SharingStarted.Lazily, "")
    val sharedFlow = flow(300.milliseconds, "fromShare").shareIn(scope, SharingStarted.Lazily)
}

fun main(): Unit = runBlocking {
    val reciter = SplashReciter(this)
    launch {
        reciter.stateFlow.collect { println("    **** state $it") }
    }
    launch {
        reciter.sharedFlow.collect { println("    **** shared $it") }
    }
}

