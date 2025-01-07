package com.example.kotlintraining.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val scope1 = CoroutineScope(Job())

    val job1 = scope1.launch {
        delay(1000)
        println("print job1")
        throw RuntimeException("job1 launch throwing exception!")
    }

    val job2 = scope1.launch {
        delay(2000)
        println("print job2")
    }
    // wait for completion of both jobs
    joinAll(job1, job2)
    println("END of main coroutine")
}