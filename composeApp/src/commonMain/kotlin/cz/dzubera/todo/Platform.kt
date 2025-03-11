package cz.dzubera.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform