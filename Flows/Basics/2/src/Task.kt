import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val nurseryRhyme = flow {
    emit("Hey diddle diddle,")
    delay(10.milliseconds)
    emit("The cat and the fiddle,")
    delay(10.milliseconds)
    emit("The cow jumped over the moon;")
    emit("The little dog laughed")
    delay(10.milliseconds)
    emit("        To see such sport,")
    delay(10.milliseconds)
    emit("And the dish ran away with the spoon.")
    delay(10.milliseconds)
}

fun main() = runBlocking {
    nurseryRhyme.collect {
        println(it)
    }
}