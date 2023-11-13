package com.example.jettodoapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task) //suspend = 非同期ワンショットクエリ

    @Query("SELECT * FROM Task")
    fun loadAllTasks(): Flow<List<Task>> // Flow = オブザーバブルクエリ

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}