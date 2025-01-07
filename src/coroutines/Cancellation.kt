package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val scope1 = CoroutineScope(Job())
    val scope2 = CoroutineScope(Job())

    val job1 = scope1.launch {
        delay(1000)
        println("print job1")
    }

    val job2 = scope1.launch {
        delay(2000)
        println("print job2")
    }

    val job3 = scope2.launch {
        delay(1000)
        println("print job3")
    }

    val job4 = scope2.launch {
        delay(2000)
        println("print job4")
    }
    scope1.cancel()
    scope2.cancel()
//    job3.cancel()
    joinAll(job1, job2, job3, job4)
    println("END of main coroutine")
}