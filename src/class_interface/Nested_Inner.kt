import class_interface.Person
import class_interface.Printable
import class_interface.Transitionable

class Outer {
    val outerProperty = "Outer Property"

    // Nested class
    class Nested {
        fun display() = "This is from Nested class"
    }
}

class SplOuter {
    val outerProperty = "Outer Property"

    // Inner class
    inner class SplInner {
        fun display() = "Accessing: $outerProperty from Inner class"
    }
}

fun main() {
    // Accessing the nested class
    val nested = Outer.Nested()
    println(nested.display()) // Output: This is from Nested class

    val splInner = SplOuter().SplInner()
    println(splInner.display())


    val distanceKm = Kilometers(100)
    println(convertToMiles(distanceKm))
}

@JvmInline
value class Kilometers(val value: Int)

@JvmInline
value class Miles(val value: Int)

fun convertToMiles(km: Kilometers): Miles {
    return Miles((km.value * 0.621371).toInt())
}
