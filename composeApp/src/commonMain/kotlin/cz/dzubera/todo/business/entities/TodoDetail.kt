package cz.dzubera.todo.business.entities

data class TodoDetail(val userId: Int, val id: Int, val title: String, val completed: Boolean)