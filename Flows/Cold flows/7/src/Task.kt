import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.basket
import net.maiatoday.rhymes.wishes
import kotlin.time.Duration.Companion.milliseconds

fun basketOfWishesMashup(): Flow<String> = channelFlow {
    launch {
        for (line in basket) {
            delay(100.milliseconds)
            send(line)
        }
    }

    launch {
        for (line in wishes) {
            delay(150.milliseconds)
            send("    $line")
        }
    }
}

fun main() = runBlocking {
    basketOfWishesMashup().collect {
        println(it)
    }
}