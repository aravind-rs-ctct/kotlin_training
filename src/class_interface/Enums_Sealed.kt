package class_interface

interface Printable {
    fun printMessage()
}

enum class TrafficLightState(val message: String) : Printable {
    RED("Stop") {
        override fun nextState(): TrafficLightState = GREEN
        override fun printMessage() = println("You have to $message now")
    },
    GREEN("Go") {
        override fun nextState(): TrafficLightState = YELLOW
        override fun printMessage() = println("You can $message now")
    },
    YELLOW("Slow down") {
        override fun nextState(): TrafficLightState = RED
        override fun printMessage() = println("You have to $message")
    };

    abstract fun nextState(): TrafficLightState
}


fun main() {
    var currentState = TrafficLightState.RED

    for (state in TrafficLightState.entries) {
        println("Entry name ${state.name} and ordinal ${state.ordinal}")
    }

    println("Message in Green:  ${TrafficLightState.valueOf("GREEN").message}")

    println("-----")
//    while (true) {
//        println("Current state: $currentState and message ${currentState.message}")
//        currentState.printMessage()
//
//        currentState = currentState.nextState()
//        Thread.sleep(2000) // Simulate a 1-second delay
//    }

    var tmpState: TrafficLightStateSealed = TrafficLightStateSealed.RED
    while (tmpState is Transitionable) {
        println("Current sealed state: $tmpState and message ${tmpState.message}")
        tmpState = (tmpState as Transitionable).nextState()
    }

    println("None state with default toString ${TrafficLightStateSealed.NONE}")
    println("None state as data object ${TrafficLightStateSealed.NONE_WITH_DATA}")
}


sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Failure(val error: String) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}

// Example usage
fun processApiResponse(response: ApiResponse<String>) {
    when (response) {
        is ApiResponse.Success -> println("Received: ${response.data}")
        is ApiResponse.Failure -> println("Error: ${response.error}")
        ApiResponse.Loading -> println("Loading...")
    }
}

//Traffic Light with None
sealed interface Transitionable {
    abstract fun nextState(): TrafficLightStateSealed
}

sealed class TrafficLightStateSealed(val message: String = "") {
    object RED : TrafficLightStateSealed("Stop"), Transitionable {
        override fun nextState(): TrafficLightStateSealed = GREEN
    }

    object GREEN : TrafficLightStateSealed("Go"), Transitionable {
        override fun nextState(): TrafficLightStateSealed = YELLOW
    }

    object YELLOW : TrafficLightStateSealed("Slow down"), Transitionable {
        override fun nextState(): TrafficLightStateSealed = NONE
    }

    object NONE : TrafficLightStateSealed("Inactive")

    data object NONE_WITH_DATA: TrafficLightStateSealed("This has data class powered toString method")
}
