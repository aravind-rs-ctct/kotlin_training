package class_interface

class Individual {
    val name: String
    val age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    companion object {
        fun createIndividual(name: String, age: Int): Individual {
            return Individual(name, age)
        }
        var randomValue = 30
        const val MAX_AGE = 120
    }
}

fun main(){

    Individual.randomValue = 40

    val individual = Individual.createIndividual("Aravind", 35)
    println("Individual $individual.name and $individual.age")
}