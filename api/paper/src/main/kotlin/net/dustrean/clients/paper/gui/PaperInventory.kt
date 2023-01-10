package net.dustrean.clients.paper.gui

import net.dustrean.api.ICoreAPI
import net.dustrean.clients.gui.Gui
import net.dustrean.clients.gui.GuiType
import net.dustrean.clients.gui.inventory.AbstractInventory
import net.dustrean.clients.item.UnassignedItemStack
import net.dustrean.api.language.component.inventory.InventoryComponentProvider
import net.dustrean.api.language.placeholder.PlaceholderProvider
import net.dustrean.clients.paper.item.ItemConstants.paper
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import java.util.*

class PaperInventory(uniqueId: UUID, parent: Gui) : AbstractInventory(uniqueId, parent), InventoryHolder{

    var inventory: Inventory? = null

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
        inventory?.setItem(slot, itemStack.assign(uniqueId).paper())
    }

    private suspend fun getTitle(): Component {
        val built = InventoryComponentProvider().apply(parent.languageProvider.invoke(uniqueId))
        val player = ICoreAPI.INSTANCE.getPlayerManager().getPlayerByUUID(uniqueId)
            ?: throw IllegalStateException("Player not found")
        val langaugeId = ICoreAPI.INSTANCE.getLanguageManager().getLanguage(player.languageId)?.id
            ?: ICoreAPI.INSTANCE.getLanguageManager().getDefaultLanguage().id
        val provider = ICoreAPI.INSTANCE.getLanguageManager().getInventory(langaugeId, built)
        return ICoreAPI.INSTANCE.getLanguageManager().deserialize(
            provider.rawTitle,
            provider.serializerType,
            PlaceholderProvider().apply(built.placeholderProvider).parse(provider.rawTitle)
        )
    }

    override fun getInventory(): Inventory {
        if(inventory == null) return Bukkit.createInventory(this, 9)
        return inventory!!
    }

}