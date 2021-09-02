package deb.raf.studentapp.ui.studentsList

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import deb.raf.studentapp.data.adapter.UsersListAdapter
import deb.raf.studentapp.data.database.Database
import deb.raf.studentapp.data.model.User
import deb.raf.studentapp.databinding.ActivityListStudentsBinding
import deb.raf.studentapp.ui.start.StartActivity

class ListStudentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListStudentsBinding
    private  var studentsList : List<User>? = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getStudentsFromDB(this)

        binding.recyclerView.adapter =
            UsersListAdapter(
                studentsList,
                ::onClickAddButton,
                ::onClickShowButton
            )

        binding.buttonBack.setOnClickListener {
            initButtonBack(this)
        }

    }

    fun getStudentsFromDB(context: Context){
       studentsList =  Database.getDatabase(context)?.userDao()?.getStudents()
    }

    fun onClickAddButton(intent: Intent){
        startActivity(intent)
    }

    fun onClickShowButton(intent: Intent){
        startActivity(intent)
    }

    private fun initButtonBack(context: Context){
        startActivity(Intent(context, StartActivity::class.java))
    }
}