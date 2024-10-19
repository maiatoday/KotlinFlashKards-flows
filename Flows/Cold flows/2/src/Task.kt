import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.tenamalin

val tenamalinRhyme = flow {
    tenamalin.forEach { emit(it) }
}

fun main() = runBlocking {
    tenamalinRhyme.collect { println(it) }
}