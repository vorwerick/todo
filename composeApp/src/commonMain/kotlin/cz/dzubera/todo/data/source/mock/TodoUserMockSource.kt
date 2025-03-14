package cz.dzubera.todo.data.source.mock

import cz.dzubera.todo.domain.entities.User
import cz.dzubera.todo.data.repository.UserRepository
import cz.dzubera.todo.domain.entities.UserNotFoundException

class TodoUserMockSource : UserRepository {


    override fun login(userId: Int): Result<User?> {
        val result = UsersMock.users.firstOrNull { it.id == userId }
        if (result == null) {
            return Result.failure(UserNotFoundException("User not found"))
        }
        return Result.success(result)
    }


    override fun getUser(userId: Int): Result<User?> {
        val result = UsersMock.users.firstOrNull { it.id == userId }
        if (result == null) {
            return Result.failure(UserNotFoundException("User not found"))
        }
        return Result.success(result)
    }

    override fun logout() {}
}