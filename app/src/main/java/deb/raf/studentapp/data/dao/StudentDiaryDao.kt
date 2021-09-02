package deb.raf.studentapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.studentapp.data.model.StudentDiary
import deb.raf.studentapp.data.model.User

@Dao
interface StudentDiaryDao {

    @Query("SELECT * FROM StudentDiary")
    fun getAll(): List<StudentDiary>

    @Insert
    fun insert(studentDiary: StudentDiary)

    @Insert
    fun insertAll(vararg studentdiary: StudentDiary)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM studentdiary WHERE name=:name AND surname=:surname ")
    fun getGradesAndSubjectBySurname(surname: String, name: String) : List<StudentDiary>
}