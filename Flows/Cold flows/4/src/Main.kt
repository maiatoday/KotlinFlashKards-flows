import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.tenamalin

val tenamalinRhyme = flow {
    println("Tenamalin Rhyme starts to emit...")
    tenamalin.forEach { emit(it) }
}

fun main() = runBlocking {
    println("Main: starts running, flow is not emitting yet")
    println("Main: make a new filtered flow")
    val tenamalinRhymeEndsWithT = tenamalinRhyme
        .filter { it.startsWith("T") }
    println("Main: collect the filtered tenamalin Rhyme flow")
    tenamalinRhymeEndsWithT.collect { println(it) }
    println("Main: finished collecting")
}
