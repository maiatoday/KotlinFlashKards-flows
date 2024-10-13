import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.maiatoday.rhymes.pudding
import kotlin.time.Duration.Companion.milliseconds

val peasePudding = flow {
    println("Flow starts")
    for (line in pudding) {
        emit(line)
    }
}

fun main() = runBlocking {
    peasePudding
        .collect{ println(it) }
    delay(9.milliseconds)
    println("------ serve the same strings again, 9 milliseconds old -------")
    peasePudding
        .collect{ println(it) }
}
