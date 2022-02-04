package com.azimsiddiqui.todolistjetpackcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.azimsiddiqui.todolistjetpackcompose.data.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDataBase : RoomDatabase() {

    abstract fun getDao() : TodoDao
}