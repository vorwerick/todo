package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.domain.entities.TodoDetail
import org.koin.mp.KoinPlatform.getKoin

class GetTasksUseCase(val userId: Int) : UseCase<List<TodoDetail>> {

    val repository: TaskRepository = getKoin().get()

    override suspend fun use(): List<TodoDetail> {
        val result = repository.getTasks(userId)
        return result
    }
}