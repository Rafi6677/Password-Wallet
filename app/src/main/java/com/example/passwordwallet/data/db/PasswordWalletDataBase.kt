package com.example.passwordwallet.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passwordwallet.data.db.dao.UserDAO
import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.data.db.model.Password

@Database(
    entities = [
        User::class,
        Password::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PasswordWalletDataBase : RoomDatabase(){

    abstract fun UserDAO(): UserDAO
    abstract fun PasswordDAO(): PasswordDAO

}