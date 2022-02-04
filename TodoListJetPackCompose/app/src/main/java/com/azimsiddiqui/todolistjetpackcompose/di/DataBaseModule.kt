package com.azimsiddiqui.todolistjetpackcompose.di

import android.app.Application
import androidx.room.Room
import com.azimsiddiqui.todolistjetpackcompose.data.room.TodoDao
import com.azimsiddiqui.todolistjetpackcompose.data.room.TodoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun providesDataBase(application: Application) : TodoDataBase =
        Room.databaseBuilder(
            application,
            TodoDataBase::class.java,
             "TodoDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDao(db : TodoDataBase) : TodoDao = db.getDao()
}