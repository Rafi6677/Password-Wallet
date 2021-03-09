package com.example.passwordwallet.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.passwordwallet.data.db.model.Password

interface PasswordDAO {

    @Delete
    suspend fun deletePassword(password: Password)

    @Update
    suspend fun updatePassword(password: Password)

    @Query("SELECT * FROM password")
    suspend fun getAllStoredPasswords(): List<Password>

    @Query("SELECT * FROM password WHERE is_main_password = 1")
    suspend fun getMainPassword(): Password

    @Insert
    suspend fun insertPassword(password: Password)

}