package com.example.kotlintraining.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
// supervisorScope:
// supervisorScope is a suspend function that creates a new coroutine scope with a supervisor job.
    measureTimeMillis { supervisorScopeExample() }.also { println("coroutineScopeExample completed in $it ms") }

    measureTimeMillis { supervisorScopeExceptionExample() }.also { println("coroutineScopeExceptionExample completed in $it ms") }

    println("END of main coroutine")
}


// failure does not affect other children in the supervisor scope
suspend fun supervisorScopeExceptionExample() = supervisorScope {
    launch {
        delay(1000) // delay for 1 second to simulate some work
        println("supervisorScope task 1 throwing exception")
        throw RuntimeException("task 1 exception")
    }

    launch {
        delay(2000) // delay for 1 second to simulate some work
        println("supervisorScope task 2")
    }
}

suspend fun supervisorScopeExample() = supervisorScope {
    launch {
        delay(1000) // delay for 1 second to simulate some work
        println("task 1")
    }

    launch {
        delay(2000) // delay for 1 second to simulate some work
        println("task 2")
    }
}