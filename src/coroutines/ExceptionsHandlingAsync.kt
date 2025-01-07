package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

fun main() = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }

    val scope = CoroutineScope(Job())
    val customScopeDeferred = scope.async { //root coroutine
        println("Throwing exception from async from a root coroutine#1")
        throw IllegalStateException("customScopeDeferred illegal state exception ") // Nothing will be printed, relying on user to call await
    }

    // async builder always catches all exceptions and represents them in the resulting Deferred
    // object, so its CoroutineExceptionHandler has no effect either.
    val deferred = GlobalScope.async(exceptionHandler) { // root coroutine
        println("Throwing exception from async from a root coroutine#2")
        throw ArithmeticException() // Nothing will be printed, relying on user to call await
    }

    val deferred2 = async(exceptionHandler) { // child coroutine
        println("Throwing exception from async child coroutine")
        throw RuntimeException("Throwing from child coroutine async")
    }

    try {
        customScopeDeferred.await()
    } catch (e: Exception) {
        println("customScopeDeferred Try catch Caught $e")
    }
    try {
        deferred.await()
    } catch (e: Exception) {
        println("Try catch Caught $e")
    }
    println("END")
}