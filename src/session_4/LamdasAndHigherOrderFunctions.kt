package com.example.kotlintraining

fun applyOperation(x: Int, operation: (Int) -> Int): Int { // function type as parameter
    return operation(x)
}

fun double(x: Int): Int {
    return 2 * x
}

fun getDoubleFunction(): (Int) -> Int {
    return ::double
}

// a custom class that implements a function type as an interface:
class DoubleClass : (Int) -> Int {
    override operator fun invoke(x: Int): Int = 2 * x
}

fun main() {
    println("Passing function reference: " + applyOperation(5, ::double)) //passing function reference
    val operation = { x: Int -> x * 2 } //lamda expression - type inferred as (Int) -> Int
    val operation2: (Int) -> Int = { it * 2 } //lamda expression
    println("passing lamda expression : " + applyOperation(5, operation))
    val anotherOperation = fun(x: Int): Int { return x * 2 } // anonymous function
    println("passing anonymous anotherOperation : " + applyOperation(5, anotherOperation))
    // According to Kotlin convention, if the last parameter of a function is a function, then a
    // lambda expression passed as the corresponding argument can be placed outside the parentheses:
    //it: implicit name of a single parameter
    println("passing trailing lamda : " + applyOperation(5) { it * 2 }) //passing lamda outside paranthheses is known as trailing lamda

    println("passing custom class for function type : " + applyOperation(5, DoubleClass()))


    // Invoking a function type variable
    println("Invoking a function type variable: " + operation.invoke(5))
    println("Invoking a function type variable: " + operation(5))

    // Calling functions which has return type as Function type
    println("Invoking function with function as return type: " + getDoubleFunction().invoke(5))
    println("Invoking function with function as return type: " + getDoubleFunction()(5))

    //Function types with receiver
    val appendTotalStringLength: String.(String) -> String = { other -> this.repeat(2) + other }
    println("Function types with receiver: " + appendTotalStringLength("Hello", "world")) // Hello is receiver
    println("Function types with receiver: " + "Hello".appendTotalStringLength("world"))
}