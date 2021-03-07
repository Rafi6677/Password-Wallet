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

    @Insert
    suspend fun insertPassword(password: Password)

}