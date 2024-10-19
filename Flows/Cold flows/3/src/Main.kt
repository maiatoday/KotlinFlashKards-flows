import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.tenamalin

val tenamalinRhyme = flow {
    println("Tenamalin Rhyme starts to emit...")
    tenamalin.forEach { emit(it) }
}

fun main() = runBlocking {
    println("Main: starts running, flow is not emitting yet")
    println("Main: collect the tenamalin Rhyme flow")
    tenamalinRhyme.collect { println(it) }
    println("Main: finished collecting")
}
