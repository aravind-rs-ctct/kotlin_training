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
        println("Start sending..")
        for (x in 1..5) {
            delay(100)
            channel.send(x * x)
        }
    }
    println("Start receiving..")
    // here we print five received integers:
    repeat(5) { println("Received: ${channel.receive()}") }

    launch {
        for (x in 5..10) {
            channel.send(x * x)
        }
        channel.close() // we're done sending
    }

    // here we print received values using `for` loop (until the channel is closed)
    for (y in channel) {
        println("Iterating in channel value: $y")
    }

    println("Done!")
}