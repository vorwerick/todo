package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.repository.UserRepository
import cz.dzubera.todo.data.source.cache.AuthCache
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import cz.dzubera.todo.domain.entities.UserNotFoundException
import org.koin.mp.KoinPlatform.getKoin

class LogoutUseCase() : UseCase<Unit> {

    val repository: UserRepository = getKoin().get()

    override suspend fun use(): Unit {
        val result = repository.logout()
        AuthCache.user = null
        return Unit
    }
}