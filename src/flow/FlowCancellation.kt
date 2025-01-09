package com.example.kotlintraining.flow

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// creates a cold flow
private val flow: Flow<Int> = flow {
    println("flow: Start on Thread: ${Thread.currentThread().name}")
    for (i in 1..4) {
        // Emissions from flow builder are cancellable by default — each call to emit also calls ensureActive.
        emit(i)
        delay(500)
    }
}

fun main() = runBlocking {
    val job = launch {
        // Collect the flow and print each value
        flow.collect {
            println("flow: $it")
        }
    }
    delay(1000)
    println("Cancel!")
    job.cancel()

    println("Cancel the flow using cancel() function")
//    flow.collect {
//        if(it == 2) cancel()
//        println("First flow collect: $it")
//    }

//    (1..5).asFlow().collect { value ->
//        if (value == 3) cancel()
//        println("as flow collect: $value")
//    }

    (1..5).asFlow().cancellable().collect { value ->
        if (value == 3) cancel()
        println("as flow collect: $value")
    }
}