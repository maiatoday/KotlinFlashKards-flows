import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<Int> = flow {
    for (i in 1..20) {
        delay(100.milliseconds)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    countFlow().collect { value ->
        when (value) {
            2 -> println("$value, buckle my shoe")
            4 -> println("$value, knock at the door")
            6 -> println("$value, pick up sticks")
            8 -> println("$value, lay them straight")
            10 -> println("$value, a big fat hen")
            12 -> println("$value, dig and delve")
            14 -> println("$value, maids a-courting")
            16 -> println("$value, maids in the kitchen")
            18 -> println("$value, maids in waiting")
            20 -> println("$value, my plate's empty!")
            else -> print("$value, ")
        }
    }
}