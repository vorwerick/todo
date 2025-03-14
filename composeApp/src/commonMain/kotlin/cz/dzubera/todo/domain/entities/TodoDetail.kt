package cz.dzubera.todo.domain.entities

data class TodoDetail(val userId: Int, val id: Int, var title: String, var completed: Boolean)