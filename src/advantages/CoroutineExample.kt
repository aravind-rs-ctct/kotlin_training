package advantages
import kotlinx.coroutines.*

suspend fun printDotWith1SecDelay() {
    delay(1000L)
    print('.')
}
fun main(): Unit {
    var time = System.currentTimeMillis()
    runBlocking {
        repeat(100_000) {
            launch {
                printDotWith1SecDelay()
            }
        }
    }
    time = System.currentTimeMillis() - time;
    println("Time taken $time ms")
}