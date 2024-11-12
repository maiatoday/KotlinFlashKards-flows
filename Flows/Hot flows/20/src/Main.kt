import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.basket
import kotlin.time.Duration.Companion.milliseconds

val  wishFlow: Flow<String> = channelFlow {
    launch {
        for (line in basket) {
            delay(100.milliseconds)
            send(line)
        }
    }
    launch {
        for (line in basket) {
            delay(200.milliseconds)
            send(line)
        }
    }
}

fun main() = runBlocking {
    wishFlow.collect {
        println(it)
    }
}
