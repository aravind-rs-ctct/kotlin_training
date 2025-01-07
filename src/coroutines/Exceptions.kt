package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val job = GlobalScope.launch() {
        println("Inside launch block")
        throw AssertionError("launch throwing exception!")
    }
    val deferred = GlobalScope.async() {
        println("Inside async block")
        throw RuntimeException("Async exception")
    }
    job.join()
//    deferred.await()
    println("END")
}