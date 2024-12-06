package typecast_expressions

fun main(){
    var numberRange = 1..25
    var stringRange = "a".."z"
    var descendingRange = 25 .. 1
    var rangeToNumber = 1.rangeTo(25)
    rangeToNumber = 1 until 50
    var descendingRangeTo = 25.rangeTo(5)
    var floatingPointRange = 1.0.rangeTo(10.0)

    println(numberRange.toList())

    println("is f in string range ${"f" in stringRange}")
    println(descendingRange.sum())

    println(rangeToNumber.count())
    println(floatingPointRange)

    if(3 in numberRange){
        println("Yes, 3 is within the range")
    }

    var progression = (30 downTo 20).step(2)

    println("Progression value is "+progression.toList())

    var sequenceOfNumbers = generateSequence(1) {it+2}

    println("sequence count is "+sequenceOfNumbers.take(100).toList())

////////////////////////////Loops/////
    for(i in 1..20 step 5){
    println(i)
    }

    progression.forEach { value -> println("Number in range is $value") }

    val stringArray = arrayOf("John","Doe","Clark","Kent","Bruce","Wayne","Tony","Stark","Howard","Stark")
    var index = 0
    do {
        println(stringArray[index])
        index++
    }while(index in 1..9)


    index = -1
    while(index < 10){
        index++
        println("$index")
    }
}