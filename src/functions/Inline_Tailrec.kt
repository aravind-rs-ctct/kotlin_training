package functions

class Student(val age: Int, val name: String) {
    fun printDetails () = println("Student name is $name and age is $age")
}

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
    val student = Student(35, "Aravind")
    student.printDetails()

    fibonacciTailRec(500000)
}