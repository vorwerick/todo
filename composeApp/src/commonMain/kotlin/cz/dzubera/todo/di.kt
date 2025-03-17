package cz.dzubera.todo

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.data.repository.UserRepository
import cz.dzubera.todo.data.source.http.TodoTasksHttpSource
import cz.dzubera.todo.data.source.mock.TodoUserMockSource
import io.ktor.client.*
import org.koin.dsl.module

val modules = module {
    //single<TaskRepository> { TodoTasksMockSource() }
    single<TaskRepository> { TodoTasksHttpSource() }
    single<UserRepository> { TodoUserMockSource() }
    single<HttpClient> {
        createHttpClient()
    }

}