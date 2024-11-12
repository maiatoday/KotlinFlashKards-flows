import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.dishSpoon
import kotlin.time.Duration.Companion.milliseconds

val nurseryRhyme = flow {
    println("Starting")
    for (line in dishSpoon) {
        emit(line)
        delay(10.milliseconds)
    }
}

fun main() = runBlocking {
    println("Has the nurseryRhyme started?")
    nurseryRhyme.collect {
        println(it)
    }
}
