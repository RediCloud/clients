package net.dustrean.api.paper.item

import net.dustrean.api.item.Constants
import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.enums.InteractType
import net.dustrean.api.paper.listenEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import java.util.*
import org.bukkit.inventory.ItemStack as BukkitItemStack

class ItemEvents {
    init {
        fun BukkitItemStack?.getItemStack(): ItemStack? =
            Constants.items[
                this?.itemMeta?.persistentDataContainer?.get(
                    ItemConstants.KEY,
                    ItemConstants.UUIDTagType()
                )
            ]
        listenEvent<PlayerInteractEvent> {
            val itemStack = (item.getItemStack() ?: return@listenEvent)
            val cancel = itemStack.interactHandler?.invoke(
                itemStack, player.uniqueId, Optional.of(InteractType.valueOf(action.name))
            )
            if(cancel == true) isCancelled = true
        }

        listenEvent<PlayerDropItemEvent> {
            val itemStack = (itemDrop.itemStack.getItemStack() ?: return@listenEvent)
            val cancel = itemStack.dropHandler?.invoke(itemStack, player.uniqueId)
            if(cancel == true) isCancelled = true
        }

        listenEvent<InventoryClickEvent> {
            val itemStacks = listOfNotNull(
                whoClicked.inventory.getItem(hotbarButton)?.getItemStack(),
                cursor?.getItemStack(),
                currentItem?.getItemStack()
            )
            var cancel = false
            itemStacks.forEach {
                if (it.blockClick) isCancelled =
                    true // If any of the items are blocked, cancel the event, regardless of the others
                if(it.clickHandler?.invoke(it, whoClicked.uniqueId) == true) cancel = true
            }
            if(cancel) isCancelled = true
        }

        listenEvent<PlayerSwapHandItemsEvent> {
            val itemStacks = listOfNotNull(
                mainHandItem?.getItemStack(),
                offHandItem?.getItemStack()
            )
            var cancel = false
            itemStacks.forEach {
                if (it.blockClick) isCancelled =
                    true // If any of the items are blocked, cancel the event, regardless of the others
                if(it.clickHandler?.invoke(it, player.uniqueId) == true) cancel = true
            }
            if(cancel) isCancelled = true
        }
    }
}