package coroutines

import advantages.User

data class UserData(val user: User, val posts: Posts)
data class Posts(val postContent: String)