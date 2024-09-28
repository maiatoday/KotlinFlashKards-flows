import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<Int> = flow {
    for (i in 1..8) {
        delay(100.milliseconds)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            print(".")
            delay(100.milliseconds)
        }
    }
    countFlow().collect { value ->
        when (value) {
            2 -> println("$value, buckle my shoe")
            4 -> println("$value, knock at the door")
            6 -> println("$value, pick up sticks")
            8 -> println("$value, lay them straight")
            else -> print("$value, ")
        }
    }
}
