package com.azimsiddiqui.todolistjetpackcompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "desc")
    val description : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}
