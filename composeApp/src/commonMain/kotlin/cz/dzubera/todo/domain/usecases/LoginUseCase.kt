package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.data.repository.UserRepository
import cz.dzubera.todo.data.source.cache.AuthCache
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import cz.dzubera.todo.domain.entities.User
import cz.dzubera.todo.domain.entities.UserNotFoundException
import org.koin.mp.KoinPlatform.getKoin

class LoginUseCase(val userId: Int) : UseCase<User?> {

    val repository: UserRepository = getKoin().get()

    override suspend fun use(): User? {
        val result = repository.login(userId)
        AuthCache.user = result.getOrNull()
        return result.getOrNull()


    }
}