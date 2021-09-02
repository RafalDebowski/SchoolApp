package deb.raf.studentapp.ui.studentActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import deb.raf.studentapp.R
import deb.raf.studentapp.data.adapter.GradesAdapter
import deb.raf.studentapp.data.database.Database
import deb.raf.studentapp.data.model.StudentDiary
import deb.raf.studentapp.databinding.ActivityStudentsGradesBinding

class StudentsGradesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentsGradesBinding
    private var listStudentDiary: List<StudentDiary>? = listOf()
    private lateinit var name: String
    private lateinit var surname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentsGradesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("NAME").toString()
        surname = intent.getStringExtra("SURNAME").toString()

        getGradesByName(this)

        binding.recyclerView.adapter =
            GradesAdapter(listStudentDiary)


        binding.buttonBack.setOnClickListener {
            initButtonBack(this)
        }

    }

    private fun getGradesByName(context: Context) {
        listStudentDiary = Database.getDatabase(context)?.studentsDiaryDao()
            ?.getGradesAndSubjectBySurname(surname, name)
    }

    private fun initButtonBack(context: Context) {
        startActivity(Intent(context, StudentActivity::class.java))
    }
}