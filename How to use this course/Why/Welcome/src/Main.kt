import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.oneTwo
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<Int> = flow {
    for (i in 1..8) {
        delay(100.milliseconds)
        emit(i)
    }
}

fun main() = runBlocking {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            print(". ")
            delay(100.milliseconds)
        }
    }
    countFlow().collect { value ->
        if (oneTwo.containsKey(value))
            println("$value, ${oneTwo[value]}")
        else print("$value, ")
    }
}
