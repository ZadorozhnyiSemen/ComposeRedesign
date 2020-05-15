package com.compose.redesign.scooter.data

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.compose.redesign.scooter.data.items.ItemsRepository
import com.compose.redesign.scooter.data.items.impl.FakeItemsRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

interface AppContainer {
    val itemsRepository: ItemsRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    private val executorService: ExecutorService by lazy {
        Executors.newFixedThreadPool(4)
    }

    private val mainHandler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }

    override val itemsRepository: ItemsRepository by lazy {
        FakeItemsRepository(
            executorService = executorService,
            mainHandler = mainHandler,
            resources = applicationContext.resources
        )
    }

}