package deb.raf.studentapp.ui.studentActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import deb.raf.studentapp.databinding.ActivityStudentBinding
import deb.raf.studentapp.ui.login.LoginActivity
import deb.raf.studentapp.ui.login.LoginViewModel
import deb.raf.studentapp.ui.login.LoginViewModelFactory

class StudentActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding : ActivityStudentBinding
    private lateinit var  name : String
    private lateinit var  surname : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        name = intent.getStringExtra("NAME").toString()
        surname = intent.getStringExtra("SURNAME").toString()

        binding.showGrades.setOnClickListener {
            val intent = Intent(this, StudentsGradesActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("SURNAME", surname)
            startActivity(intent)
        }
        initLogoutButton()
    }

    private fun initLogoutButton() {
        binding.logoutButton.setOnClickListener {
            loginViewModel.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }




}