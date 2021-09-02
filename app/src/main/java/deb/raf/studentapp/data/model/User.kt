package deb.raf.studentapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERS")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var UserId: Int? = null,

    @ColumnInfo(name = "email")
    var email: String = "",

    @ColumnInfo(name = "password")
    var password: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "surname")
    var surname: String = "",

    @ColumnInfo(name = "role")
    var role: String = "",

    @ColumnInfo(name = "display name")
    var displayName: String = ""
)