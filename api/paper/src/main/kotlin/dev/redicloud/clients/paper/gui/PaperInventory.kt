package dev.redicloud.clients.paper.gui

import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiType
import dev.redicloud.clients.gui.inventory.AbstractInventory
import dev.redicloud.clients.item.UnassignedItemStack
import dev.redicloud.clients.paper.item.ItemConstants.paper
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import java.util.*

class PaperInventory(uniqueId: UUID, parent: Gui) : AbstractInventory(uniqueId, parent), InventoryHolder {

    private var inventory: Inventory? = null

    override suspend fun updateView() {
        updateTitle()
    }

    override fun close() {
        inventory?.viewers?.forEach {
            it.closeInventory()
        }
    }

    override suspend fun open() {
        val player = Bukkit.getPlayer(uniqueId) ?: return
        inventory = if (parent.type == GuiType.CHEST) {
            Bukkit.createInventory(null, (parent.rows * 9) - 1, getTitle())
        } else {
            Bukkit.createInventory(null, InventoryType.valueOf(parent.type.name), getTitle())
        }
        items.forEach { (slot, itemStack) ->
            inventory!!.setItem(slot, itemStack.assign(uniqueId).paper())
        }
        player.openInventory(inventory!!)
    }

    override suspend fun updateTitle() {
        if (inventory == null) return
        val newInventory = if (parent.type == GuiType.CHEST) {
            Bukkit.createInventory(null, (parent.rows * 9) - 1, getTitle())
        } else {
            Bukkit.createInventory(null, InventoryType.valueOf(parent.type.name), getTitle())
        }
        newInventory.contents = inventory!!.contents
        inventory = newInventory
        inventory!!.viewers.forEach {
            it.openInventory(inventory!!)
        }
    }

    override suspend fun updateItem(slot: Int, itemStack: UnassignedItemStack) {
        inventory?.clear()
        items.forEach { (slot, itemStack) ->
            inventory?.setItem(slot, itemStack.assign(uniqueId).paper()) }
        inventory?.setItem(slot, itemStack.assign(uniqueId).paper())
    }

    override fun getInventory(): Inventory {
        if (inventory == null) return Bukkit.createInventory(this, 9)
        return inventory!!
    }

}