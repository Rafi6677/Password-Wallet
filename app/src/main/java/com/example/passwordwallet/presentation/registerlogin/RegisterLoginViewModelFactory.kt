package com.example.passwordwallet.presentation.registerlogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.passwordwallet.domain.usecase.SavePasswordUseCase
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class RegisterLoginViewModelFactory(

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterLoginViewModel::class.java)) {
            return RegisterLoginViewModel(

            ) as T
        }

        throw IllegalArgumentException("Unknown view model class")
    }

}