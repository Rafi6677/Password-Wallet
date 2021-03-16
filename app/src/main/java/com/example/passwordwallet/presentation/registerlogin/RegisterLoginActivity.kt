package com.example.passwordwallet.presentation.registerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.passwordwallet.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterLoginActivity : AppCompatActivity() {

    val viewModel by viewModels<RegisterLoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)
        supportActionBar!!.hide()
    }

}