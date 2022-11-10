package com.brafik.reqreslist.data.local

import androidx.lifecycle.LiveData
import com.brafik.reqreslist.data.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val appDao: UserDao) {

    fun getAllRecords(): LiveData<List<User>> {
        return appDao.getAllRecords()
    }

    fun insertRecord(dataUser: User) {
        appDao.insertRecords(dataUser)
    }

    fun deleteAllRecords() {
        appDao.deleteAllRecords()
    }
}