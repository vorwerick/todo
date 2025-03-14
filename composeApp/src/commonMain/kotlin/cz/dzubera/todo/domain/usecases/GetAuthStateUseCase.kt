package cz.dzubera.todo.domain.usecases

import cz.dzubera.todo.data.source.cache.AuthCache
import cz.dzubera.todo.domain.entities.TodoDetail
import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import cz.dzubera.todo.domain.entities.User
import cz.dzubera.todo.domain.entities.UserNotFoundException

class GetAuthStateUseCase {

    suspend operator fun invoke(userId: Int): User? {
        val repository = TodoUserMockSource()
        val result = repository.login(userId)
        AuthCache.user = result.getOrNull()
        return result.getOrNull()
    }
}