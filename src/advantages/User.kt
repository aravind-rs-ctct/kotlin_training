package advantages

class User (val id: Int, var name: String, var surName: String, var age: Int, var description: String?) {
    fun printDescription() = description?.let { println("description is $description") }

    init {
        val userInfo = UserInfo(id, name, surName, age, description)
    }
}


