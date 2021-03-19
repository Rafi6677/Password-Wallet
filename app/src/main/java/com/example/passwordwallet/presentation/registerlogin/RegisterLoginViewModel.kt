package com.example.passwordwallet.presentation.registerlogin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordwallet.data.auth.AuthenticationOperations
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.domain.usecase.AuthenticateUserUseCase
import com.example.passwordwallet.domain.usecase.GetUserByLoginUseCase
import com.example.passwordwallet.domain.usecase.SavePasswordUseCase
import com.example.passwordwallet.domain.usecase.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class RegisterLoginViewModel @Inject constructor(
    private val authenticateUserUseCase: AuthenticateUserUseCase,
    private val getUserByLoginUseCase: GetUserByLoginUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    fun getUserByLogin(login: String): LiveData<User> {
        val user = MutableLiveData<User>()
        viewModelScope.launch {
            val result = getUserByLoginUseCase.execute(login)
            user.postValue(result)
        }
        return user
    }

    fun registerUser(
        login: String,
        password: String,
        salt: String,
        isPasswordKeptAsHash: Boolean
    ): User {
        val user = User(0, login, password, salt, isPasswordKeptAsHash)
        viewModelScope.launch {
            saveUserUseCase.execute(user)
        }
        return user
    }

}