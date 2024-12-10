package class_interface

data class Person (val id: Int, var name: String, var surName: String, var age: Int, var description: String?)

fun main(){
    val user = Person(257,"Aravind", "Babu", 36, "Android developer")

    println("User detail : $user")

    val (id, name, description) = user
    println("Destructured values $id, name: $name, description: $description surname: ${user.component3()}")

    val clonedUser = user.copy(id = 258,name="Niresh", surName = "Vasudevan")
    println("Cloned User values $clonedUser")

    val duplicate = Person(257,"Aravind", "Babu", 36, "Android developer")
    println("Equals check ${user.equals(duplicate)}")
    println("== check ${user == duplicate}")
    println("=== check ${user === duplicate}")

    val personList = listOf(user, clonedUser, duplicate)
    for((id, name, surname) in personList){
        println("Details $id, $name, $surname")
    }


    ///
    val database = Database(Connection())
    DatabaseManager.initialize(database)

    val connection = DatabaseManager.getConnection()
    println("Database connection: $connection")
}

/// SingleTon example
class Database(val connection: Connection)
class Connection

object DatabaseManager {
    private lateinit var database: Database

    fun initialize(db: Database) {
        database = db
    }

    fun getConnection(): Connection {
        if (!::database.isInitialized) {
            throw IllegalStateException("DatabaseManager is not initialized")
        }
        return database.connection
    }
}
