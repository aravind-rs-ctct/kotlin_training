package functions

//inline functions
inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

fun performTask(){
    val timeTaken = measureTimeMillis {
        // Some time-consuming operation here
        repeat(1000000) {
            // Do something
        }
    }
    println("Time taken: $timeTaken milliseconds")
}

//Compiled code version
//fun performTask(){
//    val timeTaken = {
//        val start = System.currentTimeMillis()
//        repeat(1000000) {
//            // Do something
//        }
//        System.currentTimeMillis() - start
//    }
//    println("Time taken: $timeTaken milliseconds")
//}

inline fun <T> withLogging(message: String, noinline block: () -> T): T {
    println("Starting: $message")
    val result = block()
    println("Finished: $message")
    return result
}

tailrec fun fibonacciTailRec(n: Int, a: Int = 0, b: Int = 1) {
    if (n == 0) {
        return
    }
    print("$a")
    fibonacciTailRec(n - 1, b, a + b)
}

fun main(){
    fibonacciTailRec(500000)
}