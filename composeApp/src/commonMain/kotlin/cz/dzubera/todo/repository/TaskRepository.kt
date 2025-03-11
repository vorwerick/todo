package cz.dzubera.todo.repository

interface TaskRepository {

    fun getTaskDetail(userId: Int, taskId: Int)
    fun getTasks(userId: Int)
    fun updateTaskName(userId: Int, taskId: Int, newName: String)
    fun updateTaskState(userId: Int, taskId: Int, newState: Boolean)

}