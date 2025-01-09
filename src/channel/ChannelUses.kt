package com.example.kotlintraining.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    //A Channel is conceptually very similar to BlockingQueue.
    // One key difference is that instead of a blocking put operation it has a suspending send,
    // and instead of a blocking take operation it has a suspending receive.
    val channel = Channel<Int>()

    launch {
        // this might be heavy CPU-consuming computation or async logic,
        // we'll just send five squares
        println("Coroutine 1 Start sending..")
        for (x in 1..5) {
            channel.send(x * x)
        }
    }

    launch {
        // this might be heavy CPU-consuming computation or async logic,
        // we'll just send five squares
        println("Coroutine 2 Start sending..")
        for (x in 6..10) {
            channel.send(x * x)
        }
    }

    launch {
        println("Coroutine 3 Start receiving..")
        // here we print received values using `for` loop (until the channel is closed)
        for (y in channel) {
            println("Coroutine 3 Received value: $y")
        }
    }

    launch {
        println("Coroutine 4 Start receiving..")
        // here we print received values using `for` loop (until the channel is closed)
        for (y in channel) {
            println("Coroutine 4 Received value: $y")
        }
    }
    delay(2000)
    channel.close() // we're done sending
    println("Done!")
}