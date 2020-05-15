package com.compose.redesign.scooter.data.items

import com.compose.redesign.scooter.data.CallResult
import com.compose.redesign.scooter.domain.PricedItem
import com.compose.redesign.scooter.domain.PromotedItem

interface ItemsRepository {

    fun getItems(callback: (CallResult<List<PricedItem>>) -> Unit)

    fun getPromotedItems(callback: (CallResult<List<PromotedItem>>) -> Unit)

}