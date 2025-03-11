package cz.dzubera.todo.business.usecases

import cz.dzubera.todo.business.entities.TodoDetail
import cz.dzubera.todo.source.mock.TodoTasksMockSource

class UpdateTaskStateUseCase<T> {

    suspend operator fun invoke(userId: Int, taskId: Int, newState: Int): Result<List<TodoDetail>> {
        val repository = TodoTasksMockSource()

        repository.updateTaskState()
        return Result.success()
    }
}