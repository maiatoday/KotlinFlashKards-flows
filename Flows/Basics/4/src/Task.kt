import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val greenAndYellowFlow = flow {
    emit("A-tisket a-tasket")
    delay(10.milliseconds)
    emit("A green and yellow basket")
    delay(10.milliseconds)
    emit("I wrote a letter to my friend")
    delay(10.milliseconds)
    emit("And on the way I dropped it,")
    delay(10.milliseconds)
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