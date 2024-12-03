package functions

import advantages.User

var splFunction = println("This is a splFunction")

// Top level function
fun parseJson(jsonString: String): User {
    // JSON parsing logic using a library like Gson or Moshi
    return Gson().fromJson(jsonString, User::class.java)
}

//Local function
//adding helper functions within a complex function
fun factorial(n: Int) {
    fun factorialRecursive(n: Int): Int {
        return if (n == 0) 1 else n * factorialRecursive(n - 1)
    }
    println("Factorial of $n is ${factorialRecursive(n)}")
}

fun main() {
    val student = User( 35, "Aravind", "Babu", 34, "TBD")
    student.printDescription()
    splFunction
    factorial(5)

    //custom class's extension fucntion
    student.clearData()
    println("is data incomplete : ${student.incomplete}")
}

//No access to private members :
//      Extension functions cannot access the private or protected members of the class they are extending.
//Member function takes precedence :
//      If a class has a member function with the same signature as an extension function, the member function will be called.
//No inheritance:
//      Extension functions do not support inheritance, so they cannot be used if you require polymorphic behavior or need to override methods.
//No backing field:
//      Extension properties cannot store state or data. They are effectively read-only properties.


//access modifiers
//private: Visible only within the same file.  
//internal: Visible within the same module.  
//protected: Visible within the same class hierarchy.  
//public: Visible everywhere
private fun String.escapeForXml() : String {
    return this
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
}
//Extension property
val User.incomplete: Boolean
    get() = surName.isEmpty()

fun User.clearData(){
    name = ""
    age = 0
    surName = ""
    description = ""
}








