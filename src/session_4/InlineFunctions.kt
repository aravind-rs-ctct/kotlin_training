package com.example.kotlintraining

// The inline modifier affects both the function itself and the lambdas passed to it:
// all of those will be inlined into the call site.
inline fun performOperation(x: Int, noinline operation: (Int) -> Int): Int {
    println("performOperation invoking passed operation")// function type as parameter
    return operation(x)
}

fun main() {
    println("calling performOperation")
    println(performOperation(5) { it * 2 })
}