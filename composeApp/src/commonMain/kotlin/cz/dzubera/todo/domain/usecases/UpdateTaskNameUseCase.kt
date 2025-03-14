package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.mock.TodoTasksMockSource

class UpdateTaskNameUseCase(val userId: Int,val  taskId: Int,val newName: String): UseCase<Boolean> {


    override suspend fun use(): Boolean {
        val repository = TodoTasksMockSource()
        val result = repository.updateTaskName(userId, taskId, newName)

        return result

    }
}