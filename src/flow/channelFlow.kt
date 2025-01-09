package com.example.kotlintraining.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private val flow = flowOf(7, 8)

// Use channelFlow if the collection and emission of a flow are to be separated into multiple
// coroutines. it is also a cold flow.
private val channelFlow = channelFlow {
    println("channelFlow: Start")
    for (i in 1..3) {
        send(i)
        delay(500)
    }
    withContext(Dispatchers.IO) {
        send(4)
    }

    launch(Dispatchers.Default) {
        send(5)
    }

    GlobalScope.launch { send(6) }

    flow.collect() {
        send(it)
    }
}

fun main() = runBlocking {
    channelFlow.collect() {
        println("channelFlow collect: $it Thread: ${Thread.currentThread().name}")
    }
}