package com.example.kotlintraining.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private val flow = flow {
    emit(1) // Ok
    GlobalScope.launch { emit(2) } // emission from another coroutine is not allowed
    withContext(Dispatchers.IO) {
        // emit should happen strictly in the dispatchers of the block in order to preserve
        // the flow context.
        emit(3) // Will fail with ISE
    }
}

fun main() = runBlocking {
    // flow.collect() // Will fail with ISE
    flow.collect {
        println("flow collect: $it")
    }
}