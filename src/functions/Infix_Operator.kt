package functions

import advantages.add

infix fun Int.plus(other: Int): Int {
    return this + other
}

infix fun Int.minus(other: Int): Int {
    return this - other
}

//improved readability
fun main() {
    val result = 5 plus 3 minus 1
    println(result) // Output: 7

    val v1 = Vector2D(3.0, 4.0)
    val v2 = Vector2D(1.0, 2.0)

    val sum = v1 + v2
    val scaled = v1 * 2.0

    println("Sum: $sum")
    println("Scaled: $scaled")

    longMethod("Aravind", "Chennai", 36, "Android developer")
    longMethod(name="Niresh", address = "South Chennai")

}

//Operator Overloading :  data class?
data class Vector2D(val x: Double, val y: Double)

operator fun Vector2D.plus(other: Vector2D): Vector2D {
    return Vector2D(x + other.x, y + other.y)
}

operator fun Vector2D.times(scalar: Double): Vector2D {
    return Vector2D(x * scalar, y * scalar)
}

fun longMethod(name: String = "Untitled", address:String, age: Int = 35, description: String = "TBD") {
    println("Details Name: $name ,Address: $address,  Age: $age, description : $description")
}