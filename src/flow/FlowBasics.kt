package com.example.kotlintraining.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking


// Create a flow that emits three values
private val flow1: Flow<Int> = flowOf(1, 2, 3)

// Creates a flow from the given suspendable block.
private val flow2: Flow<Int> = flow {
    for (i in 4..6) {
        delay(500)
        emit(i)
    }
}

private val flow3 = (7..9).asFlow()

fun main() = runBlocking {
    // Collect the flow and print each value
    flow1.collect {
        println("collect flow1: $it")
    }

    flow2.collect {
        println("collect flow2: $it")
    }

    flow3.collect { value ->
        println("collect flow 3: $value")
    }

    println("Done")
}