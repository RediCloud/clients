package net.dustrean.api.minestom.lobby.register

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.ItemStackLike
import java.util.*

object ItemRegister {
    private val items: List<ItemStackLike> // static list, not changing due to own api
        get() = listOf(

        )

    private val scope = CoroutineScope(Dispatchers.IO)

    fun get(uuid: UUID?): List<Deferred<ItemStack>> = items.map { scope.async { it.get(uuid) } }
}