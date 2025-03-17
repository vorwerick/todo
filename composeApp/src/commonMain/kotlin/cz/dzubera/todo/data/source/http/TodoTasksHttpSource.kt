package cz.dzubera.todo.data.source.http

import cz.dzubera.todo.data.repository.TaskRepository
import cz.dzubera.todo.domain.entities.TodoDetail
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.koin.mp.KoinPlatform.getKoin

class TodoTasksHttpSource : TaskRepository {
    val client: HttpClient = getKoin().get()

    override suspend fun getTaskDetail(userId: Int, taskId: Int): TodoDetail? {
        return client.get(urlString = "https://jsonplaceholder.typicode.com/todos/$taskId").body()
    }

    override suspend fun getTasks(userId: Int): List<TodoDetail> {
        val response: String = client.get("https://jsonplaceholder.typicode.com/todos").bodyAsText()
        return Json.decodeFromString(ListSerializer(TodoDetail.serializer()), response).filter { it.userId == userId }
    }

    override suspend fun updateTaskName(userId: Int, taskId: Int, newName: String): Boolean {
        val response = client.put(urlString = "https://jsonplaceholder.typicode.com/todos/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(JsonObject(mapOf("title" to JsonPrimitive(newName))))
        }
        return response.status == HttpStatusCode.OK
    }

    override suspend fun updateTaskState(userId: Int, taskId: Int, newState: Boolean): Boolean {
        val response = client.put(urlString = "https://jsonplaceholder.typicode.com/todos/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(JsonObject(mapOf("completed" to JsonPrimitive(newState))))
        }
        return response.status == HttpStatusCode.OK
    }


}