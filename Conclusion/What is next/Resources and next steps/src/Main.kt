import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<Int> = flow {
    for (i in 1..8) {
        delay(100.milliseconds)
        emit(i)
    }
}

fun main() = runBlocking {
    countFlow().collect { value ->
        when (value) {
            1 -> print("One potato, ")
            2 -> print("two potato, ")
            3 -> print("three potato, ")
            4 -> println("four")
            5 -> print("Five potato, ")
            6 -> print("six potato, ")
            7 -> print("seven potato, ")
            else -> println("raw.")
        }
    }
}

