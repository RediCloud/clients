package net.dustrean.api.minestom.inventory

import kotlinx.coroutines.*
import net.dustrean.api.inventory.Inventory
import net.dustrean.api.minestom.getPlayer
import net.dustrean.api.minestom.item.ItemConstants.minestom
import net.minestom.server.entity.Player
import net.minestom.server.inventory.InventoryType
import java.util.*
import net.minestom.server.inventory.Inventory as MinestomInventory

object InventoryConstants {
    fun Inventory.open(player: Player) = open(player.uuid)
    fun Inventory.open(uuid: UUID) {
        val scope = CoroutineScope(Dispatchers.Default)
        val player = uuid.getPlayer() ?: return
        player.closeInventory()
        player.openInventory(MinestomInventory(InventoryType.valueOf("CHEST_${lines}_ROW"), name(uuid)).apply {
            runBlocking {
                awaitAll(*items.map { (i, item) ->
                    scope.async {
                        setItemStack(i, item.get(uuid).minestom())
                    }
                }.toTypedArray())
            }
        })
    }
}