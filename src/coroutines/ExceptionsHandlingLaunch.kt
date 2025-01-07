package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("exceptionHandler Caught $exception")
    }

    val job = GlobalScope.launch(exceptionHandler) {
        println("Inside launch block")
        throw RuntimeException("launch throwing exception!")
    }

    val job2 = GlobalScope.launch() {
        println("Inside launch block#2")
        try {
            throw RuntimeException("launch throwing RuntimeException!")
        } catch (e: Exception) {
            println("Try catch Caught $e")
        }
    }

    job.join()
    job2.join()
    println("END")
}