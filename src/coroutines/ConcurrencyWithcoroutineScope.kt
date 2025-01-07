package com.example.kotlintraining.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    measureTimeMillis { coroutineScopeExample() }.also { println("coroutineScopeExample completed in $it ms") }

    measureTimeMillis { coroutineScopeExceptionExample() }.also { println("coroutineScopeExceptionExample completed in $it ms") }

    println("END of main coroutine")
}

// coroutineScope:
// coroutineScope is a suspend function that creates a new coroutine scope.
suspend fun coroutineScopeExample() = coroutineScope {
    launch {
        delay(1000) // delay for 1 second to simulate some work
        println("task 1")
    }

    launch {
        delay(2000) // delay for 1 second to simulate some work
        println("task 2")
    }

    println("coroutineScope END")
}

// failure affects other children in the coroutine scope
suspend fun coroutineScopeExceptionExample() = coroutineScope {
    launch {
        delay(1000) // delay for 1 second to simulate some work
        println("task 1 throwing exception")
        throw RuntimeException("task 1 exception")
    }

    launch {
        delay(2000) // delay for 1 second to simulate some work
        println("task 2")
    }
}