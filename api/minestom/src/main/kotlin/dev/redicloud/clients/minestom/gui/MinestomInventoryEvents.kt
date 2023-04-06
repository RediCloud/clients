package dev.redicloud.clients.minestom.gui

import dev.redicloud.clients.gui.GuiInteractionModifier
import dev.redicloud.clients.gui.impl.BaseGui
import dev.redicloud.minestom.application.events.eventNode
import dev.redicloud.clients.minestom.item.ItemConstants.getItemStack
import net.minestom.server.event.EventFilter
import net.minestom.server.event.inventory.InventoryCloseEvent
import net.minestom.server.event.inventory.InventoryOpenEvent
import net.minestom.server.event.inventory.InventoryPreClickEvent
import net.minestom.server.event.inventory.PlayerInventoryItemChangeEvent
import java.util.*

class MinestomInventoryEvents {

    init {
        eventNode("gui_events", EventFilter.INVENTORY) {
            addListener(InventoryPreClickEvent::class.java) {
                if (it.inventory == null) return@addListener
                if (!it.inventory!!.hasTag(MinestomGuiProvider.TAG)) return@addListener
                val identifier = it.inventory!!.getTag(MinestomGuiProvider.TAG)!!
                val gui = MinestomGuiProvider.GUIS[UUID.fromString(identifier.split("_")[1])] ?: return@addListener

                val item = it.clickedItem
                val itemStack = it.clickedItem.getItemStack() ?: return@addListener

                gui.outSideClickAction?.invoke(it.player.uuid, itemStack)

                if (gui is BaseGui) {
                    gui.getSlotAction(it.slot)?.invoke(it.player.uuid, itemStack)
                }

                if (gui.interactionModifiers.contains(GuiInteractionModifier.PREVENT_OTHER_ACTIONS)) it.isCancelled =
                    true
                if (gui.interactionModifiers.contains(GuiInteractionModifier.PREVENT_ITEM_SWAP)) it.isCancelled = true
            }
            addListener(PlayerInventoryItemChangeEvent::class.java) {
                if (it.inventory == null) return@addListener
                if (!it.inventory!!.hasTag(MinestomGuiProvider.TAG)) return@addListener
                val identifier = it.inventory!!.getTag(MinestomGuiProvider.TAG)!!
                val gui = MinestomGuiProvider.GUIS[UUID.fromString(identifier.split("_")[1])] ?: return@addListener

                gui.dragAction?.invoke(it.player.uuid, it.newItem.getItemStack())
            }
            addListener(InventoryCloseEvent::class.java) {
                if (it.inventory == null) return@addListener
                if (!it.inventory!!.hasTag(MinestomGuiProvider.TAG)) return@addListener
                val identifier = it.inventory!!.getTag(MinestomGuiProvider.TAG)!!
                val gui = MinestomGuiProvider.GUIS[UUID.fromString(identifier.split("_")[1])] ?: return@addListener

                gui.closeAction?.invoke(it.player.uuid)
            }
            addListener(InventoryOpenEvent::class.java) {
                if (it.inventory == null) return@addListener
                if (!it.inventory!!.hasTag(MinestomGuiProvider.TAG)) return@addListener
                val identifier = it.inventory!!.getTag(MinestomGuiProvider.TAG)!!
                val gui = MinestomGuiProvider.GUIS[UUID.fromString(identifier.split("_")[1])] ?: return@addListener
                gui.openAction?.invoke(it.player.uuid)
            }
        }
    }

}