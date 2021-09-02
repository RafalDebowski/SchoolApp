package deb.raf.studentapp.ui.chooseRole

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import deb.raf.studentapp.data.database.Database
import deb.raf.studentapp.databinding.ActivityChooseRoleBinding
import deb.raf.studentapp.ui.start.StartActivity
import deb.raf.studentapp.ui.studentActivity.StudentActivity

class ChooseRoleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseRoleBinding
    private lateinit var userEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityChooseRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userEmail = intent.getStringExtra("EMAIL").toString()

        initSaveButton(this)
    }


    private fun initSaveButton(context: Context) {
        binding.buttonSave.setOnClickListener {
            val role = binding.spinner.selectedItem.toString()

            Database.getDatabase(context)?.userDao()?.updateUser(userEmail, binding.name.text.toString(), binding.surname.text.toString(), role)

            if (role.equals("Nauczyciel")){
                startActivity(Intent(context, StartActivity::class.java))
            }else{
                startActivity(Intent(context, StudentActivity::class.java))
            }
        }
    }

}
