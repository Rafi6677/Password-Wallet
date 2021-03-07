package com.example.passwordwallet.data.db.dao

import androidx.room.Insert
import com.example.passwordwallet.data.db.model.Access

interface AccessDAO {

    @Insert
    suspend fun insertAccess(access: Access)

}