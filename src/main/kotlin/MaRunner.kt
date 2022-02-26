import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random

fun main() = runBlocking<Unit> {
    val producer = produceNumbers()
    repeat(5) {
        launchProcessor(it, producer)
    }
//    delay(950)
//    producer.cancel() // cancel producer coroutine and thus kill them all
}

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1 // start from 1
    for (i in 1..25) {
        send(x++) // produce next
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        delay(Random.nextLong(200, 1800))
        println("Processor #$id received $msg")
    }
}