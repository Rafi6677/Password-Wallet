package com.example.passwordwallet.data.db.dao

import androidx.room.*
import com.example.passwordwallet.data.db.model.Password

@Dao
interface PasswordDAO {

    @Delete
    suspend fun deletePassword(password: Password)

    @Update
    suspend fun updatePassword(password: Password)

    @Query("SELECT * FROM passwords WHERE user_id = :userId")
    suspend fun getAllStoredPasswords(userId: Int): List<Password>

    @Insert
    suspend fun insertPassword(password: Password)

}