package com.example.kotlintraining


class Student(var mark: Int) {
    fun isPassed(): Boolean {
        return mark > 40
    }
    fun print() {
        println("Student member function print() Mark: $mark")
    }
}

//Extension Function
fun Student.isExcellent(): Boolean {
    return mark > 90
}

//Extension function for String class
fun String.firstChar(): Char {
    return this[0]
}

fun Student.print() {
    println("Student Extension function print() Mark: $mark")
}

fun Student.print(message :String) {
    println("Extension Student print() Message: $message Mark: $mark")
}

val String.lastchar: Char
    get() = this[this.length - 1]


fun main() {
    // our student class extension functions
    val student = Student(92)
    println("Is passed mark: " + student.isPassed())
    println("Is excellent mark: " + student.isExcellent())
    //  extension functions for Inbuilt String class
    val str = "Hello"
    println("First Char using extension function: " + str.firstChar())
    println("Last Char using extension property: " + str.lastchar)
    // member wins over extension function
     student.print()
    // overloaded extension function
    student.print("Hello")
}