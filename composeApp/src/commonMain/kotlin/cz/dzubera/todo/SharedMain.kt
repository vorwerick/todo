package cz.dzubera.todo

import org.koin.core.logger.Level
import org.koin.mp.KoinPlatform.startKoin
import org.koin.mp.KoinPlatform.stopKoin

object SharedMain {

    fun initialize() {
        startKoin(listOf(modules), Level.DEBUG)
    }

    fun dispose() {
        stopKoin()
    }
}