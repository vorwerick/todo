package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.domain.entities.TodoDetail
import org.koin.mp.KoinPlatform.getKoin

class GetTaskDetailUseCase(val userId: Int, val taskId: Int) : UseCase<TodoDetail?> {

    val repository: TaskRepository = getKoin().get()

    override suspend fun use(): TodoDetail? {

        val result = repository.getTaskDetail(userId, taskId)
        return result
    }
}