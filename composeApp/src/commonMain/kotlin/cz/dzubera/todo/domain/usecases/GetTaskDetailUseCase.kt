package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.domain.entities.TodoDetail
import cz.dzubera.todo.domain.entities.TodoNotFoundException

class GetTaskDetailUseCase(val userId: Int, val taskId: Int) : UseCase<TodoDetail?> {

    override suspend fun use(): TodoDetail? {
        val repository = TodoTasksMockSource()

        val result = repository.getTaskDetail(userId, taskId)
        return result
    }
}