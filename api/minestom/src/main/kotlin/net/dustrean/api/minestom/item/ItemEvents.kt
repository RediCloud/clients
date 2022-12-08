package net.dustrean.api.minestom.item

import net.dustrean.api.minestom.eventHandler
import net.dustrean.api.minestom.item.enums.InteractType
import net.minestom.server.event.EventFilter
import net.minestom.server.event.EventNode
import net.minestom.server.event.inventory.InventoryPreClickEvent
import net.minestom.server.event.item.ItemDropEvent
import net.minestom.server.event.player.PlayerBlockPlaceEvent
import net.minestom.server.event.player.PlayerStartDiggingEvent
import net.minestom.server.event.player.PlayerSwapItemEvent
import net.minestom.server.event.player.PlayerUseItemEvent
import net.minestom.server.event.trait.PlayerEvent
import java.util.*

class ItemEvents {
    init {
        val node = EventNode.type("item_events", EventFilter.ALL).apply {
            addListener(PlayerStartDiggingEvent::class.java) l@{
                if (it.player.itemInMainHand.hasTag(ItemConstants.tag)) {
                    val item = Constants.items[it.player.itemInMainHand.getTag(ItemConstants.tag)] ?: return@l
                    it.isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, it.player.uuid, Optional.of(InteractType.LEFT_CLICK_BLOCK))
                }
            }
            addListener(PlayerUseItemEvent::class.java) l@{
                if (it.itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[it.itemStack.getTag(ItemConstants.tag)] ?: return@l
                    it.isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, it.player.uuid, Optional.of(InteractType.RIGHT_CLICK_AIR))
                }
            }
            addListener(PlayerBlockPlaceEvent::class.java) {
                it.player.inventory.getItemInHand(it.hand).getTag(ItemConstants.tag)?.let { tag ->
                    val item: ItemStack = Constants.items[tag] ?: return@let
                    it.isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, it.player.uuid, Optional.of(InteractType.RIGHT_CLICK_BLOCK))
                }
            }
            addListener(ItemDropEvent::class.java) l@{
                if (it.itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[it.itemStack.getTag(ItemConstants.tag)] ?: return@l
                    it.isCancelled = item.blockDrop
                    item.dropHandler?.invoke(item, it.player.uuid)
                }
            }
            addListener(InventoryPreClickEvent::class.java) l@{
                mutableListOf(it.cursorItem, it.clickedItem).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        it.isCancelled = item.blockClick
                        item.clickHandler?.invoke(item, it.player.uuid)
                    }
                }
            }
            addListener(PlayerSwapItemEvent::class.java) l@{
                mutableListOf(
                    it.mainHandItem, it.offHandItem
                ).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        it.isCancelled = item.blockClick
                        item.clickHandler?.invoke(item, it.player.uuid)
                    }
                }
            }
        }
        eventHandler.addChild(node)
    }
}