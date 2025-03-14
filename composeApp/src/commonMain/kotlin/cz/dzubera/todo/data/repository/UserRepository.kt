package cz.dzubera.todo.data.repository

import cz.dzubera.todo.domain.entities.User

interface UserRepository {

    fun login(userId: Int): Result<User?>
    fun getUser(userId: Int): Result<User?>
    fun logout()

}