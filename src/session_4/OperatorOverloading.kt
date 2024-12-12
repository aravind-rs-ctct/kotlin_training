package com.example.kotlintraining

data class Point(val x: Int, val y: Int) {
    operator fun minus(other: Point): Point {
        return Point(this.x - other.x, this.y - other.y)
    }
}

// Overloading the '+' operator for the Point class
operator fun Point.plus(other: Point): Point {
    return Point(this.x + other.x, this.y + other.y)
}

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(3, 4)
    // Using the overloaded '+' operator
    val result = p1 + p2
    println("Addition: $result")  // Output: Point(x=4, y=6)
    println("Subtraction: ${p1 - p2}")  // Output: Point(x= -2, y=-2)
}
