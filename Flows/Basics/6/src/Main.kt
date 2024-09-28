import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

class PuddingProducer {
    private val _hotPudding = MutableSharedFlow<String>()
    val hotPudding = _hotPudding.asSharedFlow()

    fun producePudding(scope: CoroutineScope) {
        scope.launch {
            peasePudding.forEach {
                delay(10.milliseconds)
                println("Emitting $it")
                _hotPudding.emit(it)
            }
        }
    }
}

fun main(): Unit = runBlocking {
    val puddingProducer = PuddingProducer()
    println(">> No-one is listening")
    puddingProducer.producePudding(this)
    delay(40.milliseconds) // 4 messages will be emitted
    println(">> Start listening")
    val collectingJob = launch {
        puddingProducer.hotPudding.collect {
            println("    Collecting $it")
        }
    }
    delay(40.milliseconds) // give the collectingJob more time to collect
    println(">> Stop listening - Cancelling collectingJob")
    collectingJob.cancel()
}

val peasePudding = listOf(
    "PEASE-PUDDING hot,",
    "Pease-pudding cold,",
    "Pease-pudding in the pot,",
    "Nine days old.",
    "Some like it hot,",
    "Some like it cold,",
    "Some like it in the pot,",
    "Nine days old."
)
