package deb.raf.studentapp.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import deb.raf.studentapp.databinding.ActivityStartBinding
import deb.raf.studentapp.ui.login.LoginActivity
import deb.raf.studentapp.ui.login.LoginViewModel
import deb.raf.studentapp.ui.login.LoginViewModelFactory
import deb.raf.studentapp.ui.studentsList.ListStudentsActivity

class StartActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        binding = ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initLogoutButton()
        initListStudentsButton()
    }

    private fun initListStudentsButton(){
        binding.sendGradesButton.setOnClickListener {
            startActivity(Intent(this, ListStudentsActivity::class.java))
        }
    }

    private fun initLogoutButton() {
        binding.logoutButton.setOnClickListener {
            loginViewModel.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}