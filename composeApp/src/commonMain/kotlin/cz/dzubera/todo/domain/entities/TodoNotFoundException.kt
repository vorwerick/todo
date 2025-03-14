package cz.dzubera.todo.domain.entities

class TodoNotFoundException(message: String = "Not found") : Exception(message) {
}