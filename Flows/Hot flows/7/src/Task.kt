import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import net.maiatoday.rhymes.tenamalin
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class RhymeReciter {
    private val _lines = MutableSharedFlow<String> (replay = 5)
    val lines = _lines.asSharedFlow()
    private var job:Job? = null

    fun startReciting(scope: CoroutineScope) {
        job = scope.launch {
            tenamalin.forEach {
                _lines.emit(it)
                delay(100.milliseconds)
            }
        }
    }

    fun stopReciting() {
        job?.cancel()
    }
}

fun main():Unit = runBlocking {
    val reciter = RhymeReciter()
    launch {
        reciter.lines.collect { println("subscriber 1: $it") }
    }
    launch {
        delay(1.seconds) // subscriber 2 misses the beginning
        println("....subscriber 2 delayed")
        reciter.lines.collect { println("    subscriber 2: $it") }
    }
    reciter.startReciting(this)
    delay(3.seconds)
    reciter.stopReciting()
    println("Done")
}