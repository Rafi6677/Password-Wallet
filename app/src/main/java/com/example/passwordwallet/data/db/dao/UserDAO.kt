package com.example.passwordwallet.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.passwordwallet.data.db.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM users WHERE login = :login AND password_hash = :passwordHash")
    suspend fun authenticateUser(login: String, passwordHash: String): User

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User

    @Query("SELECT * FROM users WHERE login = :login")
    suspend fun getUserByLogin(login: String): User

    @Insert
    suspend fun insertUser(user: User)

}