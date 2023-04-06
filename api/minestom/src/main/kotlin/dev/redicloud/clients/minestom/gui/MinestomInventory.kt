package dev.redicloud.clients.minestom.gui

import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiType
import dev.redicloud.clients.gui.inventory.AbstractInventory
import dev.redicloud.clients.item.UnassignedItemStack
import dev.redicloud.clients.minestom.item.ItemConstants.minestom
import net.minestom.server.MinecraftServer
import net.minestom.server.inventory.Inventory
import net.minestom.server.inventory.InventoryType
import java.util.*

class MinestomInventory(uniqueId: UUID, parent: Gui) : AbstractInventory(uniqueId, parent) {

    var inventory: Inventory? = null

    override suspend fun updateView() {
        updateTitle()
        inventory?.update()
    }

    override fun close() {
        inventory?.viewers?.forEach {
            it.closeInventory()
        }
    }

    override suspend fun open() {
        val player = MinecraftServer.getConnectionManager().getPlayer(uniqueId) ?: return
        if (parent.type == GuiType.CHEST) {
            InventoryType.values().forEach {
                if (it.size != parent.rows * 9) return@forEach
                inventory = Inventory(it, getTitle())
            }
        } else {
            inventory = Inventory(InventoryType.valueOf(parent.type.name), getTitle())
        }
        inventory!!.setTag(MinestomGuiProvider.TAG, "${parent.identifier}_${uniqueId}")
        items.forEach { (slot, itemStack) ->
            inventory!!.setItemStack(slot, itemStack.assign(uniqueId).minestom())
        }
        player.openInventory(inventory!!)
    }

    override suspend fun updateTitle() {
        inventory?.title = getTitle()
        inventory?.update()
    }

    override suspend fun updateItem(slot: Int, itemStack: UnassignedItemStack) {
        inventory?.clear()
        items.forEach { (slot, itemStack) ->
            inventory?.setItemStack(slot, itemStack.assign(uniqueId).minestom())
        }
        inventory?.update()
    }
}