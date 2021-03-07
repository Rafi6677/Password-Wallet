package com.example.passwordwallet.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passwordwallet.data.db.dao.AccessDAO
import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.data.db.model.Password

@Database(
    entities = [
        Access::class,
        Password::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PasswordWalletDataBase : RoomDatabase(){

    abstract fun AccessDAO(): AccessDAO
    abstract fun PasswordDAO(): PasswordDAO

}