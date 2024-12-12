package com.example.kotlintraining


interface Printable {
    fun printValue()
}

class IntegerItem(private val value: Int) : Printable {
    override fun printValue() {
        println("value is : $value")
    }
}
class ItemWithUpperBound<T : Printable>(private val value: T) {
    fun printValue() {
        value.printValue()
    }
}

fun main() {
    val item = ItemWithUpperBound(IntegerItem(10))
    item.printValue()
}