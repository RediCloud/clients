package net.dustrean.api.clients.paper.gui

import net.dustrean.api.gui.Gui
import net.dustrean.api.gui.GuiInteractionModifier
import net.dustrean.api.gui.impl.BaseGui
import net.dustrean.api.clients.paper.item.ItemConstants.getItemStack
import net.dustrean.api.clients.paper.listenEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryOpenEvent


class PaperInventoryEvents {

    init {
        listenEvent<InventoryClickEvent> {
            if (inventory.holder !is Gui) return@listenEvent

            val paperInventory = inventory.holder as PaperInventory
            val gui = paperInventory.parent

            val item = currentItem
            val itemStack = item.getItemStack()

            gui.outSideClickAction?.invoke(whoClicked.uniqueId, itemStack)

            if (clickedInventory == null) return@listenEvent

            if (gui is BaseGui) {
                gui.getSlotAction(slot)?.invoke(whoClicked.uniqueId, itemStack)
            }

            if (gui.interactionModifiers.contains(GuiInteractionModifier.PREVENT_OTHER_ACTIONS)) isCancelled = true
            if (gui.interactionModifiers.contains(GuiInteractionModifier.PREVENT_ITEM_SWAP)) isCancelled = true
        }
        listenEvent<InventoryDragEvent> {
            if (inventory.holder !is Gui) return@listenEvent

            val paperInventory = inventory.holder as PaperInventory
            val gui = paperInventory.parent

            gui.dragAction?.invoke(whoClicked.uniqueId, cursor.getItemStack())
        }
        listenEvent<InventoryCloseEvent> {
            if (inventory.holder !is Gui) return@listenEvent

            val paperInventory = inventory.holder as PaperInventory
            val gui = paperInventory.parent

            gui.closeAction?.invoke(player.uniqueId)
        }
        listenEvent<InventoryOpenEvent> {
            if (inventory.holder !is Gui) return@listenEvent

            val paperInventory = inventory.holder as PaperInventory
            val gui = paperInventory.parent

            gui.openAction?.invoke(player.uniqueId)
        }
    }

}