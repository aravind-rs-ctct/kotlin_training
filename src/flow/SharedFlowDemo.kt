package com.example.kotlintraining.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// A hot Flow that shares emitted values among all its collectors in a broadcast fashion,
// so that all collectors get all emitted value
private val sharedFlow = MutableSharedFlow<Int>()

private val coldFlow :Flow<Int> = flow {
    println("cold flow Started")
    for (i in 1..4) {
        emit(i)
        delay(500)
    }
}

fun main() = runBlocking {
    println("emit 0")
    sharedFlow.emit(0)
    launch {
        println("start first collector..")
        sharedFlow.collect { value ->
            println("1.SharedFlow collector received: $value")
        }
    }

    launch {
        println("start second collector..")
        sharedFlow.collect { value ->
            println("2.SharedFlow collector received: $value")
        }
    }

    delay(1000)
    println("emit 1")
    sharedFlow.emit(1)
    println("emit 2")
    sharedFlow.emit(2)

    val convertedSharedFlow :SharedFlow<Int> = coldFlow.shareIn(this, WhileSubscribed())

    launch {
        println("start third collector..")
        convertedSharedFlow.collect { value ->
            println("3.SharedFlow collector received: $value")
        }
    }

    launch {
        delay(1000)
        println("start fourth collector after a delay..")
        convertedSharedFlow.collect { value ->
            println("4.SharedFlow collector received: $value")
        }
    }

    println("END")
}




