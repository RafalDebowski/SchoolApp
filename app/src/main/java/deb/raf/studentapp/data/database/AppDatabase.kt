package deb.raf.studentapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import deb.raf.studentapp.data.dao.StudentDiaryDao
import deb.raf.studentapp.data.dao.UserDao
import deb.raf.studentapp.data.model.StudentDiary
import deb.raf.studentapp.data.model.User


@androidx.room.Database(
    entities = [
        User::class,
        StudentDiary::class
    ],
    version = 4,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao?
    abstract fun studentsDiaryDao(): StudentDiaryDao?

    companion object {
        private const val DATABASE_NAME = "database.db"
        private var INSTANCE: Database? = null
        fun getDatabase(context: Context): Database? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java, DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE
            }
            return INSTANCE
        }

    }


}

