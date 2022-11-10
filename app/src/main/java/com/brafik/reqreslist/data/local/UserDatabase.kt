package com.brafik.reqreslist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brafik.reqreslist.data.models.TypeConverterDataUser
import com.brafik.reqreslist.data.models.User


@Database(entities = [User::class], version = 1)
@TypeConverters(TypeConverterDataUser::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}