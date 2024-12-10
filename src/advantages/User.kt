@file:JvmName("ExtensionUtils")
package advantages

import class_interface.Transitionable


class User (val id: Int, var name: String, var surName: String, var age: Int, var description: String?) {
    fun printDescription() = description?.let { println("description is $description") }
}

fun String.printInUpperCase() = println("Text In uppercase: ${this.uppercase()}")

fun main() {
 val user: User = User(7, "James", "Bond", 37, "Top Secret Agent")
 user.printDescription()
 user.description?.printInUpperCase()
 user.name.printInUpperCase()

    val userInfo: UserInfo = UserInfo(1, "Aravind", "Babu", 35, "Android Developer")

}

