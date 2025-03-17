package cz.dzubera.todo.data.source.mock

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.domain.entities.TodoDetail

class TodoTasksMockSource : TaskRepository {
    override suspend fun getTaskDetail(userId: Int, taskId: Int): TodoDetail? {
        return TaskMock.todos.firstOrNull { it.userId == userId && it.id == taskId }
    }

    override suspend fun getTasks(userId: Int): List<TodoDetail> {
        return TaskMock.todos.filter { it.userId == userId }
    }

    override suspend fun updateTaskName(userId: Int, taskId: Int, newName: String): Boolean {
        val res = TaskMock.todos.filter { it.userId == userId && it.id == taskId }.firstOrNull()
        if (res == null) {
            return false
        }
        res.title = newName
        return true
    }

    override suspend fun updateTaskState(userId: Int, taskId: Int, newState: Boolean): Boolean {
        val res = TaskMock.todos.filter { it.userId == userId && it.id == taskId }.firstOrNull()
        if (res == null) {
            return false
        }
        res.completed = newState
        return true
    }


}