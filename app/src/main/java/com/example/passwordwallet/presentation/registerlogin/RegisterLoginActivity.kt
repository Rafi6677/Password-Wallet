package com.example.passwordwallet.presentation.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.passwordwallet.R
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.databinding.ActivityRegisterLoginBinding
import com.example.passwordwallet.presentation.passwords.PasswordsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterLoginActivity : AppCompatActivity() {

    val viewModel by viewModels<RegisterLoginViewModel>()
    private lateinit var binding: ActivityRegisterLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterLoginBinding.inflate(layoutInflater)

        hideProgressBar()
        setContentView(binding.root)

        supportActionBar!!.hide()
    }

    fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    fun logIntoApp(user: User) {
        val bundle = Bundle().apply {
            putSerializable("user", user)
        }
        val intent = Intent(this, PasswordsActivity::class.java).apply {
            putExtras(bundle)
            addCategory(Intent.CATEGORY_HOME)
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
        finish()
    }

}