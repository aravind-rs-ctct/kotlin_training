package com.example.kotlintraining


class Item<T>(private var value: T) {

    fun setValue(value: T) {
        this.value = value
    }

    fun getValue(): T? {
        return value
    }
}

fun printGenericItem(item: Item<*>) {
    println(item.getValue())
}

fun main() {

    val item = Item(5)
    item.setValue(10)
    println(item.getValue())
    val item2 = Item("Hello")
    println(item2.getValue())

    printGenericItem(item)
    printGenericItem(item2)
}