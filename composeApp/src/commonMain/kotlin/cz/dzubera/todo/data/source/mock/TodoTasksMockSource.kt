package cz.dzubera.todo.data.source.mock

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.domain.entities.TodoDetail

class TodoTasksMockSource : TaskRepository {
    override fun getTaskDetail(userId: Int, taskId: Int): TodoDetail? {
        return TaskMock.todos.firstOrNull { it.userId == userId && it.id == taskId }
    }

    override fun getTasks(userId: Int): List<TodoDetail> {
        return TaskMock.todos.filter { it.userId == userId }
    }

    override fun updateTaskName(userId: Int, taskId: Int, newName: String): Boolean {
        val res = TaskMock.todos.filter { it.userId == userId && it.id == taskId }.firstOrNull()
        if (res == null) {
            return false
        }
        res.title = newName
        return true
    }

    override fun updateTaskState(userId: Int, taskId: Int, newState: Boolean): Boolean {
        val res = TaskMock.todos.filter { it.userId == userId && it.id == taskId }.firstOrNull()
        if (res == null) {
            return false
        }
        res.completed = newState
        return true
    }


}