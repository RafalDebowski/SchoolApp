package deb.raf.studentapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudentDiary")
class StudentDiary(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var studentDiaryId : Long? = null,

    @ColumnInfo(name = "name")
    var name :String = "",

    @ColumnInfo(name = "surname")
    var surname : String ="",

    @ColumnInfo(name = "subject")
    var subject : String ="",

    @ColumnInfo(name = "grade")
    var grade : String = ""
)