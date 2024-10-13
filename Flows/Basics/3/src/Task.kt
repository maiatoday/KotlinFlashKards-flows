import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.rain
import kotlin.time.Duration.Companion.milliseconds

val shortRhyme = flow {
    for (line in rain) {
        emit(line)
        delay(10.milliseconds)
    }
}

fun main() = runBlocking {
    shortRhyme.collect {
        println(it)
    }
}