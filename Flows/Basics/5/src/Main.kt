import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val peasePudding = flow {
    println("Flow starts")
    emit("PEASE-PUDDING hot,")
    emit("Pease-pudding cold,")
    emit("Pease-pudding in the pot,")
    emit("Nine days old.")
    emit("Some like it hot,")
    emit("Some like it cold,")
    emit("Some like it in the pot,")
    emit("Nine days old.")
}

fun main() = runBlocking {
    peasePudding
        .collect{ println(it) }
    delay(9.milliseconds)
    println("------ serve the same strings again, 9 milliseconds old -------")
    peasePudding
        .collect{ println(it) }
}
