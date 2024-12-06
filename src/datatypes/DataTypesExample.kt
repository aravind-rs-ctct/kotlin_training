package datatypes

const val DUMMY = "DUMMY"//User("12", "12","21",22, "dea")

fun main() {

    // Number data types
    val age: Int = 30 // Integer number
    val weight: Double = 65.5 // Double-precision floating-point number
    val pi: Float = 3.14159f // Single-precision floating-point number

    var numericValue: Number = 395 //any number type
    numericValue = 65.8
    numericValue = 1000L
    // Character data type
    val initial: Char = 'A'

    // Boolean data type
    val isAdult: Boolean = age >= 18

    // String data type
    val name: String = "Alice"

    // Array data type
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)

    var anyValue: Any? = 123
    anyValue = "Hello world"
    anyValue = null

    var checkType = "1234" //Type inference

    // Printing the values
    println("Age: $age")
    println("Weight: $weight")
    println("Pi: $pi")
    println("Initial: $initial")
    println("Is Adult: $isAdult")
    println("Name: $name")
    println("Numbers: ${numbers.contentToString()}")
    println("any Value : $anyValue")
//    println("value of string field $value1")
    println("checkNumber: ${checkValue(2)}")
//    println("checkNumber: ${checkValue(42)}")


    val multilineString = """
        This is a new string that has a new line.
        
        This is a start of a new paragraph
    """

    println("check multiline string: $multilineString")

}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun checkValue(num: Int) : String {
    return if(num == 1 ) {
        "one"
    }else if( num == 2) {
        "two"
    }else {
         fail("Unexpected value") // fail returns Nothing, ensuring exhaustiveness
    }
}