package com.example.passwordwallet.presentation.registerlogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordwallet.data.auth.AuthenticationOperations
import com.example.passwordwallet.domain.usecase.AuthenticateUserUseCase
import com.example.passwordwallet.domain.usecase.SavePasswordUseCase
import com.example.passwordwallet.domain.usecase.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject

@HiltViewModel
class RegisterLoginViewModel @Inject constructor(
    private val authenticateUserUseCase: AuthenticateUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    fun authenticateUser(login: String, password: String) {

    }

    fun registerUser(
        login: String,
        password: String,
        salt: String,
        isPasswordKeptAsHash: Boolean
    ) {

    }

}