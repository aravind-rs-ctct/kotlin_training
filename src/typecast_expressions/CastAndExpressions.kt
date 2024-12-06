import advantages.User
import advantages.printInUpperCase

fun guessTheType(value: Any){
    println("Is value String : ${value is String}")
    println("Is value Int : ${value is Int}")
    println("Is grade Not String : ${value !is String}")
    if(value is String && value.length > 5){
        println("String functions can be done without cast: ${value.substring(5)}")
        value.printInUpperCase()
    }
}
fun main(){

    val grade = 90
    var message = if (grade >= 90) "Excellent!"
                  else if (grade >= 80) "Very Good"
                  else if (grade >= 70) { "Good" }
                  else { "Needs Improvement" }
    println("Message is $message")
    //Type Checks
    guessTheType(90)
    println("---")
    guessTheType("Mark is : 90")

    var convertedString: String? = null
    message = convertedString as String
    println("Converted String is $convertedString")

    convertedString = grade as? String
    println("Converted String is $convertedString")


}