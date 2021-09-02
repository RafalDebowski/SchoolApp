package deb.raf.studentapp.data.dao

import androidx.room.*
import deb.raf.studentapp.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM USERS")
    fun getAll(): List<User>

    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM USERS WHERE USERS.email =:email")
    fun getUserByEmail(email: String): User

    @Query("UPDATE USERS SET role =:role, name=:name, surname=:surname WHERE email =:email ")
    fun updateUser(email: String, name: String, surname: String, role: String)

    @Query("SELECT role FROM USERS WHERE email =:email")
    fun getUserRoleByEmail(email: String): String

    @Query("SELECT * FROM USERS WHERE role ='Uczeń'")
    fun getStudents(): List<User>

}