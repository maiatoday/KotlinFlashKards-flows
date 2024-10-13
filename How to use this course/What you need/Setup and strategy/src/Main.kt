import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.oneTwo
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<Int> = flow {
    for (i in 1..20) {
        delay(100.milliseconds)
        emit(i)
    }
}

fun main() = runBlocking {
    countFlow().collect { value ->
        if (oneTwo.containsKey(value))
            println("$value, ${oneTwo[value]}")
        else print("$value, ")
    }
}