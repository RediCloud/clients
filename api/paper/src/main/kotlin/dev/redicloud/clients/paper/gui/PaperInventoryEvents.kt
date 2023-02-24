package dev.redicloud.clients.paper.gui

import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiInteractionModifier
import dev.redicloud.clients.gui.impl.BaseGui
import dev.redicloud.clients.paper.item.ItemConstants.getItemStack
import dev.redicloud.clients.paper.listenEvent
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