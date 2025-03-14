package cz.dzubera.todo.data.repository

import cz.dzubera.todo.domain.entities.TodoDetail

interface TaskRepository {

    fun getTaskDetail(userId: Int, taskId: Int): TodoDetail?
    fun getTasks(userId: Int): List<TodoDetail>
    fun updateTaskName(userId: Int, taskId: Int, newName: String): Boolean
    fun updateTaskState(userId: Int, taskId: Int, newState: Boolean): Boolean

}