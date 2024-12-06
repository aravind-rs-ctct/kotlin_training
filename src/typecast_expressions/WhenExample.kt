package typecast_expressions

import advantages.printInUpperCase
import functions.returnMultipleData


fun printType(obj: Any) {
    when (obj) {
        is String -> println("It's a String")
        is Int -> println("It's an Integer")
        is Double -> println("It's a Double")
        else -> println("Unknown type")
    }
}

fun printLength(obj: Any) {
    when (obj) {
        is String -> println("String length: ${obj.printInUpperCase()}")
        is List<*> -> println("List size: ${obj.size}")
        else -> println("Unknown type")
    }
}

fun main(){

    val x = 10

    when (x) {
        1 -> println("x is 1")
        2, 3 -> println("x is 2 or 3")
        in 4..10 -> println("x is between 4 and 10 (inclusive)")
        else -> println("x is out of range")
    }

    val result = when (x) {
        1, 2, 3 -> "Small number"
        in 4..10 -> "Medium number"
        else -> "Large number"
    }
    println(result)

    val y = 20
    when {
        x > y -> println("x is greater than y")
        x < y -> println("x is less than y")
        else -> println("x is equal to y")
    }

    printType(34)
    printType(45.5)
    printType(45L)

    printLength("This is a string")
    printLength(listOf(1,3,3,4,5,6,6))
    printLength(arrayOf(2,3,5,6,6,2))


    //Missed out data types
    val pair:Pair<Int, Float> = Pair(3, 4.5f)
    val triple:Triple<Int, Float, Double> = returnTriple()

    println("Pair value is $pair")
    println("Triple value is $triple")

    val (first: Int, second: Float, third: Double) = returnTriple()
    println("Value first: $first second: $second third: $third ")

}

fun returnTriple(): Triple<Int, Float, Double> {

    //some complex logic

    return Triple(3,4.5f, 8.8)
}