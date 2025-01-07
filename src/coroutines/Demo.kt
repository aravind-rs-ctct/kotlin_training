package com.example.kotlintraining.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Coroutines are less resource-intensive than JVM threads. Code that exhausts the JVM's available
// memory when using threads can be expressed using coroutines without hitting resource limits.
// For example, the following code launches 50,000 distinct coroutines that each waits 5 seconds
// and then prints a period ('.') while consuming very little memory:
fun main() = runBlocking {
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}

//If you write the same program using threads (remove runBlocking, replace launch with thread,
// and replace delay with Thread.sleep), it will consume a lot of memory. Depending on your
// operating system, JDK version, and its settings, it will either throw an out-of-memory error
// or start threads slowly so that there are never too many concurrently running threads.