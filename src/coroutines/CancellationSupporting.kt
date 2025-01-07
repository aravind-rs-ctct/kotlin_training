package com.example.kotlintraining.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
//            while (i < 10 && isActive) {
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("First Job Hello ${i++}")
                nextPrintTime += 500L
            }
        }
    }
    delay(1000L)
    println("Cancel!")
    job.cancel()

    //All suspend functions from kotlinx.coroutines are cancellable: withContext, delay etc.
    val cancellableJob2 = launch(Dispatchers.Default) {
        for (i in 1..10) {
            println("cancellableJob2 I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1000)
    cancellableJob2.cancel()
}