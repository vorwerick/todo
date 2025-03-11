package cz.dzubera.todo.source.mock

import cz.dzubera.todo.business.entities.User
import cz.dzubera.todo.repository.UserRepository

class TodoUserMockSource : UserRepository {

    var user: User? = null


    override fun login(userId: Int): User? {
        user = UsersMock.users.find { it.id == userId }
        return user
    }


    override fun getUser(userId: Int): User? {
        return user
    }

    override fun logout() {
        user = null
    }
}