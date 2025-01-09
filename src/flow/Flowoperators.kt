package com.example.kotlintraining.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private val flow = flow {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking {

    // Intermediate flow operators

    flow.take(2) // take only the first two values
        .collect() {
            println("flow take: $it")
        }

    val time = measureTimeMillis {
        flow.collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            println(value)
        }
    }
    println("without buffer Collected in $time ms")

    val timeWithBuffer = measureTimeMillis {
        flow.buffer().collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            println(value)
        }
    }
    println("with buffer Collected in $timeWithBuffer ms")

    val timeForConflation = measureTimeMillis {
        flow.conflate() // conflate emissions, don't process each one
            .collect { value ->
                delay(300) // pretend we are processing it for 300 ms
                println(value)
            }
    }
    println("Conflation Collected in $timeForConflation ms")

    val timeCollectLatest = measureTimeMillis {
        flow.collectLatest { value -> // cancel & restart on the latest value
                println("Collecting $value")
                delay(300) // pretend we are processing it for 300 ms
                println("Done $value")
            }
    }
    println("CollectLatest Collected in $timeCollectLatest ms")
}