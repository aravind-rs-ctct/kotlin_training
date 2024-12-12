package com.example.kotlintraining

open class Fruit {
    fun getFruit() = "Fruit"
}
class Apple : Fruit() {
    fun getApple() = "Apple"
}

class Box<out T>(private val item: T) {
    fun getItem(): T = item
}

class Processor<in T> {
    fun process(item: T) {}
}

fun main() {

    val appleBox: Box<Apple> = Box(Apple())
    val fruitBox: Box<Fruit> = appleBox

    print("fruit: ${fruitBox.getItem().getFruit()}")
    print("Apple: ${appleBox.getItem().getApple()}")

    val fruitProcessor = Processor<Fruit>()
    val appleProcessor: Processor<Apple> = fruitProcessor
}
