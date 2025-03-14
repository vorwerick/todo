package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.cache.AuthCache
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import cz.dzubera.todo.domain.entities.User
import cz.dzubera.todo.domain.entities.UserNotFoundException

class LoginUseCase(val userId: Int) : UseCase<User?> {

    override suspend fun use(): User? {
        val repository = TodoUserMockSource()
        val result = repository.login(userId)
        AuthCache.user = result.getOrNull()
        return result.getOrNull()


    }
}