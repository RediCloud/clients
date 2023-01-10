package net.dustrean.clients.minestom.gui

import net.dustrean.clients.gui.Gui
import net.dustrean.clients.gui.GuiType
import net.dustrean.clients.gui.inventory.AbstractInventory
import net.dustrean.clients.item.UnassignedItemStack
import net.minestom.server.MinecraftServer
import net.minestom.server.inventory.Inventory
import net.minestom.server.inventory.InventoryType
import java.util.*

class MinestomInventory(uniqueId: UUID, parent: Gui) : AbstractInventory(uniqueId, parent) {

    var inventory: Inventory? = null!!

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
        if(parent.type == GuiType.CHEST){
            InventoryType.values().forEach {
                if(it.size != parent.rows * 9) return
                inventory = Inventory(it, getTitle())
            }
        }else{
            inventory = Inventory(InventoryType.valueOf(parent.type.name), getTitle())
        }
        inventory!!.setTag(MinestomGuiProvider.TAG, "${parent.identifier}_${uniqueId}")
        player.openInventory(inventory!!)
    }

    override suspend fun updateTitle() {
        inventory?.title = getTitle()
        inventory?.update()
    }

    override suspend fun updateItem(slot: Int, itemStack: UnassignedItemStack) {
        inventory?.update()
    }
}