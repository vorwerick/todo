package cz.dzubera.todo.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class TodoDetail(val userId: Int, val id: Int, var title: String, var completed: Boolean)