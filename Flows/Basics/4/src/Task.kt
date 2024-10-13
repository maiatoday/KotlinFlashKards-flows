import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.basket
import kotlin.time.Duration.Companion.milliseconds

val greenAndYellowFlow = flow {
    for (line in basket) {
        emit(line)
        delay(10.milliseconds)
    }
}

suspend fun getMessages(): String = buildString {
    greenAndYellowFlow.collect {
        append(it)
        append("\n")
    }
}

fun main() = runBlocking {
    println(getMessages())
}