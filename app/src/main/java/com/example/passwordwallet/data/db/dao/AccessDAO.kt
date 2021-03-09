package com.example.passwordwallet.data.db.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.passwordwallet.data.db.model.Access

interface AccessDAO {

    @Query("SELECT * FROM access WHERE id = :mainAccessId")
    suspend fun getMainAccess(mainAccessId: Int): Access

    @Insert
    suspend fun insertAccess(access: Access)

}