package com.brafik.reqreslist.di

import android.content.Context
import androidx.room.Room
import com.brafik.reqreslist.data.local.UserDao
import com.brafik.reqreslist.data.local.UserDatabase
import com.brafik.reqreslist.data.local.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "alpha_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUsersDao(db: UserDatabase): UserDao = db.getUserDao()

    @Provides
    @Singleton
    fun providesRoomRepository(db: UserDatabase): UserRepository = UserRepository(db.getUserDao())
}