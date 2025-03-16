package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.TaskRepository
import org.koin.mp.KoinPlatform.getKoin

class UpdateTaskNameUseCase(val userId: Int,val  taskId: Int,val newName: String): UseCase<Boolean> {

    val repository: TaskRepository = getKoin().get()

    override suspend fun use(): Boolean {
        val result = repository.updateTaskName(userId, taskId, newName)

        return result

    }
}