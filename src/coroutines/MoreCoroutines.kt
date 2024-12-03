package coroutines

import advantages.User
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

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