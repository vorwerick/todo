package cz.dzubera.todo.source.mock

import cz.dzubera.todo.business.entities.TodoDetail

object TaskMock {

    val task01: TodoDetail = TodoDetail(userId = 1, id = 1, title = "Nový úkol", completed = false)
    val task02: TodoDetail = TodoDetail(userId = 1, id = 2, title = "Starý úkol", completed = true)
    val task03: TodoDetail = TodoDetail(userId = 2, id = 3, title = "Jiný úkol", completed = true)
    val task04: TodoDetail = TodoDetail(userId = 2, id = 4, title = "Pohodový úkol", completed = false)
    val task05: TodoDetail = TodoDetail(userId = 3, id = 5, title = "Žádný úkol", completed = true)
    val task06: TodoDetail = TodoDetail(userId = 3, id = 6, title = "Nový úkol 1", completed = false)

}