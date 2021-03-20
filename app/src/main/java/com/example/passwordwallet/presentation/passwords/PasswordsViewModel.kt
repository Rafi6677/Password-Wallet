package com.example.passwordwallet.presentation.passwords

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(
    private val deletePasswordUseCase: DeletePasswordUseCase,
    private val editPasswordUseCase: EditPasswordUseCase,
    private val getAllStoredPasswordsUseCase: GetAllStoredPasswordsUseCase,
    private val savePasswordUseCase: SavePasswordUseCase
) : ViewModel() {

    val passwordsList = MutableLiveData<List<Password>>()

    fun savePassword(
        hashedPassword: String,
        userId: Int,
        accountName: String,
        description: String
    ) {
        val password = Password(0, hashedPassword, userId, accountName, description)

        viewModelScope.launch {
            savePasswordUseCase.execute(password)
        }
    }

    fun getPasswordsList(user: User) {
        viewModelScope.launch {
            passwordsList.value = getAllStoredPasswordsUseCase.execute(user.id)
        }
    }

}