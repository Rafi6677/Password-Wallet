package com.example.passwordwallet.presentation.registerlogin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.domain.usecase.AuthenticateUserUseCase
import com.example.passwordwallet.domain.usecase.GetUserByLoginUseCase
import com.example.passwordwallet.domain.usecase.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
    ): LiveData<Int> {
        val user = User(0, login, password, salt, isPasswordKeptAsHash)
        val userId = MutableLiveData<Int>()
        viewModelScope.launch {
            val createdUserId = saveUserUseCase.execute(user)
            userId.postValue(createdUserId.toInt())
        }

        return userId
    }

}