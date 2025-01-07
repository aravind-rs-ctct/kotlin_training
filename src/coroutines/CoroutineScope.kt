package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val scope = CoroutineScope(Job() + CoroutineName("MainScope"))
    scope.launch {
        println("Hello, World!")
    }
    scope.launch {
        delay(1000)
        println("after delay Hello, World!")
    }
    scope.cancel()
    // once scope is cancelled, no new coroutine can be launched
    scope.launch {
        println("This will not execute")
    }
    println("END of main coroutine")
}