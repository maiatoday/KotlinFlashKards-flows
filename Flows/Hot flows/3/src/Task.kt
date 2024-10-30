import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.maiatoday.rhymes.tenamalin
import kotlin.time.Duration.Companion.milliseconds

class RhymeLastWord {
    private val _word = MutableStateFlow("")
    val word = _word.asStateFlow()
    private var job: Job? = null

    fun startReciting(scope: CoroutineScope) {
        job = scope.launch {
            tenamalin.forEach { word ->
                _word.update { word }
                delay(100.milliseconds)
            }
        }
    }

    fun stopReciting() {
        job?.cancel()
    }
}

fun main() = runBlocking {
    val reciter = RhymeLastWord()
    reciter.startReciting(this)
    delay(500.milliseconds)
    println(reciter.word.value)
    delay(500.milliseconds)
    println(reciter.word.value)
    reciter.stopReciting()
    println("Done")
}
