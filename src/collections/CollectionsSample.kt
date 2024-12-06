package collections

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap
import kotlin.collections.LinkedHashSet

fun main() {

    val immutableList: List<String> = listOf("Aravind", "Niresh", "Clint", "Bryan", "Kaleb")

    println("Output of immutableList")
    for(name in immutableList){
        println("name is $name")
    }

    var mutableList: MutableList<Int> = mutableListOf(1, 3, 3, 4, 5, 6, 7, 9)

    val set = setOf(1, 3, 5, 6, 6, 8, 11, 14, 5)
    println("Output of mutableSet")
   set.forEach { println(it) }

    val linkedSet = LinkedHashSet<String>()
    linkedSet.add("Apple")
    linkedSet.add("Orange")
    linkedSet.add("Apple") // Duplicate, won't be added
    linkedSet.add("Pineapple")
    linkedSet.add("Banana")

    println("Output of linkedSet")
    for (fruit in linkedSet) {
        println(fruit)
    }

////////////////////

    val map1 = mapOf("apple" to 1, "banana" to 2, "cherry" to 3)

    println("Output of map")
    for ((name, value) in map1) {
        println("Fruit $name is  mapped to $value")
    }

    val mutableMap = mutableMapOf<String, Int>()
    mutableMap["apple"] = 1
    mutableMap["banana"] = 2
    mutableMap["cherry"] = 3
    mutableMap["grapes"] = 4
    mutableMap["orange"] = 5

    val iterator = mutableMap.iterator();
    println("Output of mutableMap")
    while (iterator.hasNext()) {
        val entry = iterator.next()
        println("Entry details : Fruit ${entry.key} is  mapped to ${entry.value}")

    }

    //Unordered but efficient to look up
    val hashMap = HashMap<String, Int>()
    hashMap["cherry"] = 3
    hashMap["apple"] = 1
    hashMap["banana"] = 2
    println("Output for Hashmap :")
    hashMap.forEach { (name, value) -> println("Fruit $name is  mapped to $value") }


    //Map that maintains the insertion order
    val linkedMap = LinkedHashMap<String, Int>()
    linkedMap["Alice"] = 25
    linkedMap["Charlie"] = 28
    linkedMap["Bob"] = 30

    println("Output of LinkedMap")
    for ((name, age) in linkedMap) {
        println("$name is $age years old")
    }

    //Map sorted by keys
    val treeMap = TreeMap<String, Int>()
    treeMap["date"] = 8
    treeMap["banana"] = 5
    treeMap["cherry"] = 15
    treeMap["apple"] = 10

    println("Output of treeMap")
    for ((fruit, quantity) in treeMap) {
        println("$fruit: $quantity")
    }


}