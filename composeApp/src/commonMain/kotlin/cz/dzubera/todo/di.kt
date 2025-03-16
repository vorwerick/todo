package cz.dzubera.todo

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.data.repository.UserRepository
import cz.dzubera.todo.data.source.mock.TodoTasksMockSource
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import org.koin.dsl.module

val modules = module {
    single<TaskRepository> { TodoTasksMockSource() }
    single<UserRepository> { TodoUserMockSource() }
}