package com.example.kotlintraining.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private val flow: Flow<Int> = flow {
    println("flow Started Thread: ${Thread.currentThread().name}")
    for (i in 1..3) {
        delay(500)
        emit(i)
    }
}
private val flowWithFlowOnOperator: Flow<Int> = flow {
    println("flowWithFlowOnOperator Started Thread: ${Thread.currentThread().name}")
    for (i in 1..3) {
        emit(i)
    }
}.flowOn(Dispatchers.Default) // RIGHT way to change context for CPU-consuming code in flow builder

fun main() = runBlocking {
    // Collect the flow and print each value
    flow.map {
        println("map running on Thread : ${Thread.currentThread().name}")
        it * 2
    }.collect {
        println("collect: $it Thread: ${Thread.currentThread().name}")
    }

    println("Start collecting flowWithFlowOnOperator...")

    // Collect the flow and print each value
    flowWithFlowOnOperator.map {
        println("flowWithFlowOnOperator map running on Thread : ${Thread.currentThread().name}")
        it * 2
    }    // flowOn affects the upstream flow
        .flowOn(Dispatchers.IO)
        .filter {
            println("flowWithFlowOnOperator filter running on Thread : ${Thread.currentThread().name}")
            it == 2
        }.collect {
            println("flowWithFlowOnOperator collect: $it Thread: ${Thread.currentThread().name}")
        }
}