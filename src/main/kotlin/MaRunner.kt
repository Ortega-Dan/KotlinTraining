import com.kotlintest.test
import kotlinx.coroutines.*
import org.danort.App

fun main() = runBlocking {
    coroutineScope {
        launch {
            test1()
        }
        test2()
    }
}

suspend fun test1() {
    delay(100)
    println("Test 1-1")
    delay(80)
    println("Test 1-2")

}

suspend fun test2() {
    println("  Test 2-1")
    delay(150)
    println("  Test 2-2")
}