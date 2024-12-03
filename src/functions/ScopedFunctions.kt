package functions

import advantages.User

fun main(){

    val nullableString: String? = "Hello"

    //"it" is an implicit parameter in kotlin, refers to the single parameter in lambdas

    //let : Mostly used for performing some actions on it after nullsafety
    nullableString?.let { value: String ->
        println("String length: ${value.length}")
    }
    nullableString?.let {
        println("String length: ${it.length}")
    }

    val person = User(7, "James", "Bond", 30, "Secret agent")
    //run: To execute a block of code within the context of a receiver object.
    person.run {
        val missionDetails = "XYZ" //derived from complex logic
        println("Name: ${this.name}, Age: $age mission: $missionDetails")
    }

    //with: Similar to run, but mostly used in configuration / initialization purpose
    val builder = StringBuilder()
    with(builder) {
        this.append("Hello, ")
        append("world!")
    }
    println(builder.toString())


    //also
    //similar to let, it returns the original object instead of any new return data
    //without affecting the original object
    var m = 1
    m = m.also { it +1 }.also { it +1 }
    println("also output is $m")

    //apply
    var newPerson = person.apply {
        name = "Thomas"
        description = "Top secret agent"
    }
    println("person details ${person.name} is a ${person.description}, isEqual : ${person === newPerson}")
}