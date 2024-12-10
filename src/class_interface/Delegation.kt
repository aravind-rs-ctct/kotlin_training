package class_interface

import kotlin.properties.Delegates

interface Printer {
    fun handlePrint(message: String)
}

class PrinterImpl : Printer {
    override fun handlePrint(message: String) {
        println("PrinterImpl: $message")
    }
}

class DelegatingPrinter(printer: Printer) : Printer by printer

fun main() {
    val printerImpl = PrinterImpl()
    val delegatingPrinter = DelegatingPrinter(printerImpl)
    delegatingPrinter.handlePrint("Hello, Delegation!")

//    Lazy
    println("Before accessing name")
    println(name) // Prints "Initializing..." and then "Kotlin Delegation"
    println(name)

    //observable
    age = 34
    age = 45

    //vetoable
    score = 10
    println("new score is $score")
    score = -5
    println("new score is $score")

    val userInfo : User = Triple("Aravind", 7, "Developer")
}

typealias User = Triple<String, Int, String>


val name: String by lazy {
    println("Initializing...")
    "Kotlin Delegation"
}

//Delegates Observable
var age: Int by Delegates.observable(0) { property, oldValue, newValue ->
    println("${property.name} changed from $oldValue to $newValue")
}

//vetoable
var score: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    println("Trying to change ${property.name} from $oldValue to $newValue")
    newValue >= 0 // Only allow positive scores
}

