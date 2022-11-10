package com.brafik.reqreslist.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brafik.reqreslist.data.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM data")
    fun getAllRecords(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(dataUser: User)

    @Query("DELETE FROM data")
    fun deleteAllRecords()
}
