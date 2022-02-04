package com.azimsiddiqui.todolistjetpackcompose.presentation

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azimsiddiqui.todolistjetpackcompose.data.model.Todo
import com.azimsiddiqui.todolistjetpackcompose.presentation.composable.TodoRow
import com.azimsiddiqui.todolistjetpackcompose.ui.theme.TodoListJetPackComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ToDoActivity : ComponentActivity() {

    private val todoViewModel: TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListJetPackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AddToolBar()
                }
            }

        }
    }

    @Composable
    private fun AddToolBar() {
        val (showDialog, setShowDialog) = remember {
            mutableStateOf(false)
        }
        val onCloseDialog = { setShowDialog(false) }
        val onShowDialog = { setShowDialog(true) }

        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "TodoList") }) },
            content = {
               TodoRecycleView()
            },
            floatingActionButton = {
                FloatingActionButton(onClick = onShowDialog, backgroundColor = Color.Red) {
                    ShowTodoDialog(showDialog = showDialog, onCloseDialog)
                    Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
                }
            }
        )
    }


    @Composable
    fun TodoRecycleView() {
        LazyColumn {
            items(todoViewModel.response.value){ todo ->
                TodoRow(todo = todo)
            }
        }
    }

    @Composable
    fun ShowTodoDialog(showDialog: Boolean, onClose: () -> Unit) {

        val (title, setTitle) = remember {
            mutableStateOf("")
        }
        val (description, setDescription) = remember {
            mutableStateOf("")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { onClose() },
                title = { Text(text = "Add Todo") },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {

                        OutlinedTextField(
                            value = title,
                            onValueChange = {
                                setTitle(it)
                            },
                            label = { Text(text = "Title") },
                            placeholder = {
                                Text("Enter Title")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = description,
                            onValueChange = {
                                setDescription(it)
                            },
                            label = { Text(text = "Description") },
                            placeholder = {
                                Text("Enter Description")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                    }
                },
                buttons = {
                    Button(onClick = {
                        insertTodo(title, description)
                        onClose()
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "save")
                    }
                }
            )
        }

    }


    private fun insertTodo(title: String, description: String) {

        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)) {
            todoViewModel.insert(
                Todo(
                    title,
                    description
                )
            )
        } else {
            Toast.makeText(this, "Do not leave field Blank", Toast.LENGTH_SHORT).show()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TodoListJetPackComposeTheme {
           // TodoRow()
            //ShowTodoDialog(true, onClose = { false })
        }

    }

}