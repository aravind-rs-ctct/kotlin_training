package functions

import advantages.User
//Dummy class
class Gson {
    fun fromJson(stringValue: String, classType: Class<User>): User {
        return User(1,"Untitled","NA",1,"TBD")
    }
}