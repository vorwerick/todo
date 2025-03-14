package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.cache.AuthCache
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import cz.dzubera.todo.domain.entities.UserNotFoundException

class LogoutUseCase() : UseCase<Unit> {

    override suspend fun use(): Unit {
        val repository = TodoUserMockSource()
        val result = repository.logout()
        AuthCache.user = null
        return Unit
    }
}