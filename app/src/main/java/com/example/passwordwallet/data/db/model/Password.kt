package com.example.passwordwallet.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password")
data class Password(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "access_id")
    val accessId: Int,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "account_name")
    val accountName: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "is_main_password")
    val isMainPassword: Boolean
)