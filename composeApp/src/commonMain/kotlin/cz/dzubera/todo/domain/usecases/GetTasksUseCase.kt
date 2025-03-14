package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.domain.entities.TodoDetail

class GetTasksUseCase(val userId: Int) : UseCase<List<TodoDetail>> {

    override suspend fun use(): List<TodoDetail> {
        val repository = TodoTasksMockSource()

        val result = repository.getTasks(userId)
        return result
    }
}