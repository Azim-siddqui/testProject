package com.azimsiddiqui.todolistjetpackcompose.data.repository

import androidx.lifecycle.LiveData
import com.azimsiddiqui.todolistjetpackcompose.data.model.Todo
import com.azimsiddiqui.todolistjetpackcompose.data.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository @Inject constructor(private val dao : TodoDao) {

    suspend fun insert(todo: Todo) = withContext(Dispatchers.IO){
        dao.insert(todo)
    }

    fun getAllTodo() : Flow<List<Todo>> = dao.getAllTodo()
}