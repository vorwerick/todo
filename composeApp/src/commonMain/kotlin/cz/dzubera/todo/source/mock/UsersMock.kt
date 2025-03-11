package cz.dzubera.todo.source.mock

import cz.dzubera.todo.business.entities.User

object UsersMock {

    val user01: User = User(1, "Karel")
    val user02: User = User(2, "Jan")
    val user03: User = User(3, "Ivan")
    val user04: User = User(4, "Honza")
    val user05: User = User(5, "Tomáš")
    val user06: User = User(6, "Jakub")

    val users = listOf(user01, user02, user03, user04, user05, user06)

}