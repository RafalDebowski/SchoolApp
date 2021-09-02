package deb.raf.studentapp.ui.studentsList

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import deb.raf.studentapp.R
import deb.raf.studentapp.data.database.Database
import deb.raf.studentapp.data.model.StudentDiary
import deb.raf.studentapp.databinding.ActivityAddGradesBinding

class AddGradesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddGradesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddGradesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {
            saveStudentDiaryToDB(this)
        }

    }


    fun saveStudentDiaryToDB(context: Context){
        val studentDiary = StudentDiary()
        studentDiary.name = intent.getStringExtra("NAME").toString()
        studentDiary.surname = intent.getStringExtra("SURNAME").toString()
        studentDiary.subject = binding.subject.text.toString()
        studentDiary.grade = binding.grade.text.toString()

        Database.getDatabase(context)?.studentsDiaryDao()?.insert(studentDiary)
        Toast.makeText(this, "Zapisałeś ocenę", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, ListStudentsActivity::class.java))
    }
}