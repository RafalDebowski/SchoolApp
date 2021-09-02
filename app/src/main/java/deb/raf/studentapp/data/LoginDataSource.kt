package deb.raf.studentapp.data

import deb.raf.studentapp.data.model.User
import java.io.IOException

class LoginDataSource {

    fun login(username: String, password: String): Result<User> {
        try {
            val user = User(0, username)
            return Result.Success(user)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {

    }
}