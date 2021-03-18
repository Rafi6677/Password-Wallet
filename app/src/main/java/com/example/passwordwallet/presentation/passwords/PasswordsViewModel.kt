package com.example.passwordwallet.presentation.passwords

import androidx.lifecycle.ViewModel
import com.example.passwordwallet.domain.usecase.DeletePasswordUseCase
import com.example.passwordwallet.domain.usecase.EditPasswordUseCase
import com.example.passwordwallet.domain.usecase.GetAllStoredPasswordsUseCase
import com.example.passwordwallet.domain.usecase.SavePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordsViewModel @Inject constructor(
    private val deletePasswordUseCase: DeletePasswordUseCase,
    private val editPasswordUseCase: EditPasswordUseCase,
    private val getAllStoredPasswordsUseCase: GetAllStoredPasswordsUseCase,
    private val savePasswordUseCase: SavePasswordUseCase
) : ViewModel() {



}