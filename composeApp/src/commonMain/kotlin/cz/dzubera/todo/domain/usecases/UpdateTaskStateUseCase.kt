package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.TaskRepository
import org.koin.mp.KoinPlatform.getKoin

class UpdateTaskStateUseCase(val userId: Int,val  taskId: Int,val newState: Boolean): UseCase<Boolean> {

    val repository: TaskRepository = getKoin().get()

    override suspend fun use(): Boolean {
        val result = repository.updateTaskState(userId, taskId, newState)

        return result

    }
}