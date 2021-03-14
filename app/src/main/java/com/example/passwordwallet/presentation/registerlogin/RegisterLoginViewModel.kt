package com.example.passwordwallet.presentation.registerlogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordwallet.domain.usecase.SavePasswordUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@ViewModelScoped
class RegisterLoginViewModel(

) : ViewModel() {

    suspend fun saveMainPassword(passwordString: String) = viewModelScope.launch {

    }

    private fun calculateSHA512(text: String): String {
        try {
            val messageDigest = MessageDigest.getInstance("SHA-512")
            val byteMessageDigest = messageDigest.digest(text.toByteArray())
            val bigInteger = BigInteger(1, byteMessageDigest)
            var hashText = bigInteger.toString(16)

            while (hashText.length < 32) {
                hashText = "0$hashText"
            }

            return hashText
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

}