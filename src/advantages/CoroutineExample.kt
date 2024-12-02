package advantages
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}


data class UserData(val user: User, val posts: Posts)

data class Posts(val postContent: String)

suspend fun fetchUser(): User {
    delay(1000L)
    return User(1, "Tester", "007", 35, "Secret agent")
}

suspend fun fetchPosts(): Posts {
    delay(1000L)
    return Posts("Post content")
}

suspend fun fetchUserWithPosts(): UserData = coroutineScope {
    val userDetails = async {
        fetchUser()
    }
    val posts = async { fetchPosts() }
    UserData(userDetails.await(), posts.await())
}