package cz.dzubera.todo.repository

import cz.dzubera.todo.business.entities.User

interface UserRepository {

    fun login(userId: Int): User?
    fun getUser(userId: Int): User?
    fun logout()

}