package com.example.passwordwallet.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords")
data class Password(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "account_name")
    val accountName: String,
    @ColumnInfo(name = "description")
    val description: String,
)