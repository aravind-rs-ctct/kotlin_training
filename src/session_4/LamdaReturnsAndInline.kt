package com.example.kotlintraining



fun normalFunction(block: () -> Unit) {
    block()
    println("normalFunction!")
}

inline fun inlined(block: () -> Unit) {
    block()
    println("inlined!")
}

inline fun inlinedWithoutNonLocalReturns(crossinline block: () -> Unit) {
    block()
    println("inlined!")
}

fun foo() {
    normalFunction {
        return@normalFunction // OK: the lambda is inlined
    }

    inlined {
        println("inside inlined lamda")
        // non-local returns. The lambda can return from the enclosing function
        return // OK: the lambda is inlined
    }

    inlinedWithoutNonLocalReturns {
        return@inlinedWithoutNonLocalReturns
    }
}

fun main() {
    foo()
}