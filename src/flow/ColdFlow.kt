package com.example.kotlintraining.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

// Creates a cold flow from the given suspendable block. The flow being cold means that the block
// is called every time a terminal operator is applied to the resulting flow.
private val coldFlow: Flow<Int> = flow {
    println("cold flow Started")
    emit(0)
    emit(1)
}

fun main() = runBlocking {

    coldFlow.collect() {
        println("coldFlow collect: $it")
    }

    println("Calling collect again...")
    //collecting again
    coldFlow.onEach { println("coldFlow onEach: $it") }.collect()
    println("Invoking count operator...")
    // invoking a terminal operator on the flow will start the flow again
    println("coldFlow count: ${coldFlow.count()}")

    println("Done")
}