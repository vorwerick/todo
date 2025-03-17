package cz.dzubera.todo.data.repository

import cz.dzubera.todo.domain.entities.TodoDetail

interface TaskRepository {

    suspend fun getTaskDetail(userId: Int, taskId: Int): TodoDetail?
    suspend fun getTasks(userId: Int): List<TodoDetail>
    suspend fun updateTaskName(userId: Int, taskId: Int, newName: String): Boolean
    suspend fun updateTaskState(userId: Int, taskId: Int, newState: Boolean): Boolean

}