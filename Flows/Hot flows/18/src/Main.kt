import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.basket
import net.maiatoday.rhymes.wishes
import kotlin.time.Duration.Companion.milliseconds

val  basketFlow: Flow<String> = channelFlow {
    launch {
        for (line in basket) {
            delay(100.milliseconds)
            send(line)
        }
    }
}

val wishFlow = flow {
    for (wish in wishes) {
        emit(wish)
    }
}

fun main() = runBlocking {
    basketFlow.collect {
        println(it)
    }
    wishFlow.collect {
        println(it)
    }
}
