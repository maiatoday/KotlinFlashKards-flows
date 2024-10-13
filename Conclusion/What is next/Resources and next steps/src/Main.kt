import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.potatos
import kotlin.time.Duration.Companion.milliseconds

fun countFlow(): Flow<String> = flow {
    for (line in potatos) {
        delay(100.milliseconds)
        emit(line)
    }
}

fun main() = runBlocking {
    countFlow().collect { value ->
        println(value)
    }
}

