package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.mock.TodoTasksMockSource

class UpdateTaskStateUseCase(val userId: Int,val  taskId: Int,val newState: Boolean): UseCase<Boolean> {


    override suspend fun use(): Boolean {
        val repository = TodoTasksMockSource()
        val result = repository.updateTaskState(userId, taskId, newState)

        return result

    }
}