open class Agent constructor(
    val id: Int = Math.random().toInt(),
    var name: String,
    var surName: String,
    ageValue: Int,
    var description: String?
) {
    var age = ageValue
        set(value) {
            field = value
            if(value > 60){
                status = "Inactive"
            }
        }

    var status = "Active"
        private set

    var city: String = "New York"
        get() {
            return when (field) {
                "New York" -> "NY"
                "Chennai" -> "CHN"
                "Christchurch" -> "CHC"
                else -> "TBD"
            }
        }

    init {
        require(age > 30) { "Inexperienced secret agent" }
    }

    constructor(id: Int, name: String, surName: String, age: Int, description: String?, city: String) : this(
        id,
        name,
        surName,
        age,
        description
    ) {
        this.city = city
    }

    fun printDescription() = description?.let { println("description is $description") }

    override fun toString(): String {
        return "Name: $name, surname: $surName age: $age description: $description, Location: $city , status : $status"
    }
}

fun main() {
    val agent: Agent = Agent(7, "James", "Bond", 37, "Top Secret Agent")
    val indianAgent: Agent = Agent(7, "Vikram", "Hassan", 54, "Black Hawk", "Chennai")

    println(agent)
    println(indianAgent)

    indianAgent.age = 62

    println(indianAgent)

}

interface Executable {
    val emergencyContact: String
        get() = "911"

    fun execute(order: String)
    fun terminate(name: String){
        println("Terminator mode activated")
    }
}
class CIA(id: Int = Math.random().toInt(),
          name: String,
          surName: String,
          ageValue: Int,
          description: String?, val division: String): Executable, Agent(id, name, surName, ageValue, description){

    override fun execute(order: String) {
        TODO("Not yet implemented")
    }

    override val emergencyContact: String
        get() = "+019911"

    override fun terminate(name: String) {
        super.terminate(name)
    }
}

