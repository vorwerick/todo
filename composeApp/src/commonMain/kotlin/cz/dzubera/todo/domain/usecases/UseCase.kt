package cz.dzubera.todo.domain.usecases

interface  UseCase<T> {

    suspend fun use(): T
}