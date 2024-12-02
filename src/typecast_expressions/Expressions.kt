import advantages.User

fun main(){

    val grade = 90

    val message = if (grade >= 90) "Excellent!"
                  else if (grade >= 80) "Very Good"
                  else if (grade >= 70) { "Good" }
                  else { "Needs Improvement" }
    println("Message is $message")
}