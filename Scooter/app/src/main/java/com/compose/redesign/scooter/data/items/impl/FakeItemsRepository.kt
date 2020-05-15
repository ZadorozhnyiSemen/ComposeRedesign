package com.compose.redesign.scooter.data.items.impl

import android.content.res.Resources
import android.os.Handler
import com.compose.redesign.scooter.data.CallResult
import com.compose.redesign.scooter.data.items.ItemsRepository
import com.compose.redesign.scooter.domain.PricedItem
import com.compose.redesign.scooter.domain.PromotedItem
import java.util.concurrent.ExecutorService

class FakeItemsRepository(
    private val executorService: ExecutorService,
    private val mainHandler: Handler,
    private val resources: Resources
) : ItemsRepository {

    override fun getItems(callback: (CallResult<List<PricedItem>>) -> Unit) {
        execute(callback) {
            simulateNetworkLatency()
            Thread.sleep(1000L)
            mainHandler.post { callback(CallResult.Success(listOf())) }
        }
    }

    override fun getPromotedItems(callback: (CallResult<List<PromotedItem>>) -> Unit) {
        execute(callback) {
            simulateNetworkLatency()
            Thread.sleep(1000L)
            mainHandler.post { callback(CallResult.Success(listOf())) }
        }
    }

    private var networkRequestDone = false
    private fun simulateNetworkLatency() {
        if (!networkRequestDone) {
            Thread.sleep(2000L)
            networkRequestDone = true
        }
    }

    private fun execute(callback: (CallResult<Nothing>) -> Unit, block: () -> Unit) {
        executorService.execute {
            try {
                block()
            } catch (e: Exception) {
                mainHandler.post { callback(CallResult.Error(e)) }
            }
        }
    }
}