package com.azimsiddiqui.todolistjetpackcompose.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.azimsiddiqui.todolistjetpackcompose.data.model.Todo
import com.azimsiddiqui.todolistjetpackcompose.data.repository.TodoRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject constructor(private val repository: TodoRepository) : ViewModel() {

    val response : MutableState<List<Todo>> = mutableStateOf(listOf())


    private val _todoListLiveData = MutableLiveData<List<Todo>>()
    val todoListLiveData: LiveData<List<Todo>>
        get() = _todoListLiveData

    init {
        getAllTodos()
    }
    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }

    fun getAllTodos()= viewModelScope.launch {
             repository.getAllTodo().collect {
                 response.value = it
             }
        }


}