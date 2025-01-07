package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    val scope = CoroutineScope(Job())

    val firstChild = scope.launch() {
        delay(1000)
        println("The first child is cancelled")
    }
    // launch the second child
    val secondChild = scope.launch {
        delay(2000)
        // Cancellation of the first child is not propagated to the second child
        println("The first child is cancelled: ${firstChild.isCancelled}, but the second one is still active")
    }

    // wait until the first child fails & completes
    firstChild.cancel()
    println("Cancelled the first child")
    secondChild.join()
}