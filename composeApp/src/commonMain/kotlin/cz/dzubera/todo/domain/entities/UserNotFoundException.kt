package cz.dzubera.todo.domain.entities

class UserNotFoundException(message: String = "User doesnt exist") : Exception(message) {
}