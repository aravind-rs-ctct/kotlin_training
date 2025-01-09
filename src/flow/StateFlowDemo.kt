package com.example.kotlintraining.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// State flow is a special-purpose, high-performance, and efficient implementation of SharedFlow
// for the narrow, but widely used case of sharing a state.
private val stateFlow = MutableStateFlow(-1)

private val coldFlow :Flow<Int> = flow {
    println("cold flow Started")
    for (i in 1..4) {
        emit(i)
        delay(500)
    }
}

fun main() = runBlocking {
    println("emit 0")
    stateFlow.emit(0)
    launch {
        println("start first collector..")
        stateFlow.collect { value ->
            println("1.StateFlow collector received: $value")
        }
    }

    launch {
        println("start second collector..")
        stateFlow.collect { value ->
            println("2.StateFlow collector received: $value")
        }
    }

    // Updates to the value are always conflated. So a slow collector skips fast updates,
    // but always collects the most recently emitted value.
    delay(1000)
    println("emit 1")
    stateFlow.emit(1)
    println("emit 2")
    stateFlow.emit(2)

    val convertedSharedFlow :SharedFlow<Int> = coldFlow.stateIn(this, WhileSubscribed(), -1)

    launch {
        println("start third collector..")
        convertedSharedFlow.collect { value ->
            println("3.StateFlow collector received: $value")
        }
    }

    launch {
        delay(1000)
        println("start fourth collector after a delay..")
        convertedSharedFlow.collect { value ->
            println("4.StateFlow collector received: $value")
        }
    }

    println("StateFlow value: ${stateFlow.value}")
    println("END")
}




