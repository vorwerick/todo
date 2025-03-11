package cz.dzubera.todo.source.mock

import cz.dzubera.todo.repository.TaskRepository

class TodoTasksMockSource: TaskRepository {
    override fun getTaskDetail(userId: Int, taskId: Int) {
        TODO("Not yet implemented")
    }

    override fun getTasks(userId: Int) {
        TODO("Not yet implemented")
    }

    override fun updateTaskName(userId: Int, taskId: Int, newName: String) {
        TODO("Not yet implemented")
    }

    override fun updateTaskState(userId: Int, taskId: Int, newState: Boolean) {
        TODO("Not yet implemented")
    }


}