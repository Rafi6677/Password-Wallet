package com.example.passwordwallet.presentation.registerlogin

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class RegisterLoginViewModelFactory(
    private val app: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterLoginViewModel::class.java)) {
            return RegisterLoginViewModel(
                app
            ) as T
        }

        throw IllegalArgumentException("Unknown view model class")
    }

}