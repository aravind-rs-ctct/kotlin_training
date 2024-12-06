package collections

fun transformationExamples() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    println("output of map function")
    list.map { "Square of $it is ${it * it}" }.forEach {
        println(it)
    }

    println("output of mapped index and for Each indexed")
    list.mapIndexed { index: Int, i: Int -> index * i }.forEachIndexed { index, i ->
        println("Item at index $index is $i")
    }

    println("original list $list")


    println("Filtering the even numbers")
    list.filter { it % 2 == 0 }.forEach { println(it) }

    val nameList = listOf("John", "Aravind", "Jack", "Tony", "Clark")

    println("String representation ${nameList.joinToString(":")}")

    val nameMap = nameList.associateWith { it.length }
    val nameMapAgain = nameList.associateTo(mutableMapOf(), { Pair(it, it.length) })

    nameMap.forEach { key, value -> println("key : $key and value $value ") }

    println("associateTo example output")
    nameMapAgain.forEach { key, value -> println("key : $key and value $value ") }
}

fun filteringExamples(){
    val numbers = listOf(1, 2, 3, 4, 3, 2, 5, 6)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers)

    val oddNumbers = numbers.filterNot { it%2 == 0 }
    println(oddNumbers)

    val lessThanFour = numbers.takeWhile { it<4 }
    println(lessThanFour)

    val (even, odd) = numbers.partition { it%2 == 0 }
    println("even : $even & odd: $odd")

    println("does 5 exists : ${numbers.any { it == 5 }}")

    val mixedList = listOf(1, "Aravind", 2, "Kishore", 3, "Niresh")
    println(mixedList.filterIsInstance<String>())

    println(numbers.slice(4..6))

}

fun plusMinus() {
    val numbers = listOf(1, 2, 3, 4, 3, 2, 5, 6)
    val mixedList = listOf(1, "Aravind", 2, "Kishore", 3, "Niresh")

    var newList =  numbers + mixedList
    println(newList)

    newList = newList - 4
    println(newList)
}

class Person(val name: String, val age: Int, val city: String){
    override fun toString(): String {
        return  "Name: $name, age:$age, city: $city"
    }
}

fun groupingOperations() {
    val people = listOf(
        Person("Alice", 25, "Chennai"),
        Person("Bob", 30, "Paris"),
        Person("Charlie", 25, "ChristChurch"),
        Person("Zen", 32, "New York")
    )
    println(people.groupBy { it.age })

    people.groupingBy { it.age }

    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = numbers.fold(10) { acc, next -> acc + next }
    println(sum)
    println(numbers.reduce{acc, next-> acc+ next})

}

fun sortingOperations(){
    val numbers = (1..10).toList()
    println(numbers.sorted())
    println(numbers.sortedDescending())
    println(numbers.shuffled())

    val people = listOf(
        Person("Alice", 25, "Chennai"),
        Person("Bob", 30, "Paris"),
        Person("Charlie", 25, "ChristChurch"),
        Person("Zen", 32, "New York")
    )

    println(people.sortedBy { it.city })
    println(people.sortedByDescending { it.name })

}

fun main() {

//    transformationExamples()
//    filteringExamples()
//    plusMinus()
      groupingOperations()
//    sortingOperations()

}