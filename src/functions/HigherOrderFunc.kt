package functions


//Functions as variables
val add: (Int, Int)-> Int = {a, b -> a+b}
val subtract: (Int, Int)-> Int = {a, b -> a-b}

fun operate(operation: (Int, Int)-> Int) {
    println(operation(5,3))
}

fun main() {
    println(add(6,4))
    println(subtract(6,4))
    operate({x, y -> x*y})
    operate(add)
}