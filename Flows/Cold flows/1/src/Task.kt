import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.rain

val rainFlow = flow {
    rain.forEach { emit(it) }
}

fun main() = runBlocking {
    rainFlow.collect { println(it) }
}