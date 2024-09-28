import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val shortRhyme = flow {
    emit("Rain, rain, go away.")
    delay(10.milliseconds)
    emit("Come again another day,")
    delay(10.milliseconds)
}

fun main() = runBlocking {
    shortRhyme.collect {
        println(it)
    }
}