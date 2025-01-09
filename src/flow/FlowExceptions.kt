package com.example.kotlintraining.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

private val flowThrowsException = flow {
    emit(1) // Ok
    emit(2)
    throwException()
}

private val flow = flow {
    emit(1) // Ok
    emit(2)
}

fun throwException() {
    throw IllegalStateException("Exception")
}

fun main() = runBlocking {

    println("Start collecting first flow with try/catch...")
    try {
        flowThrowsException.collect {
            println("First flow collect: $it")
        }
    } catch (e: Exception) {
        println("Try catch Caught exception: $e")
    } finally {
        println("Finally block")
    }

    println("Start collecting first flow with catch operator...")


    flowThrowsException
        // cause will be null if the flow completed successfully otherwise it will contain the exception
        .onCompletion { cause -> println("Flow completed with $cause") }
        // The catch intermediate operator, honoring exception transparency,
        // catches only upstream exceptions
        .catch { e ->
            println("caught exception: $e")
            emit(3)
        }
        .collect {
            println("First flow collect: $it")
        }

    println("Start collecting second flow...")
    // catch operator is not called because the exception is from the downstream
    flow.catch { e -> println("second flow caught exception: $e") }
        .onCompletion { cause -> println("Second Flow completed with $cause") }
        .map {
            if (it != 1) {
                throw RuntimeException("RuntimeException")
            } else it
        }
        .collect {
            println("Second flow collect: $it")
        }
}