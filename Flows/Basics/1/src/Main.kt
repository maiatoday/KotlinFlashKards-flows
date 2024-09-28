import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

suspend fun theAnswer(): Int {
    delay(100.milliseconds)
    return 42
}

val theAnswers = flow {
    repeat(10) {
        delay(100.milliseconds)
        emit(it)
    }
}

fun main() = runBlocking {
    println("Here is one answer ${theAnswer()}")
    theAnswers.collect {
        println("Another answer $it")
    }
}


