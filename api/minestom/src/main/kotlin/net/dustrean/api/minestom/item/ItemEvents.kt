package net.dustrean.api.minestom.item

import net.dustrean.api.minestom.events.eventNode
import net.dustrean.api.minestom.events.listen
import net.dustrean.api.minestom.item.enums.InteractType
import net.minestom.server.event.EventFilter
import net.minestom.server.event.inventory.InventoryPreClickEvent
import net.minestom.server.event.item.ItemDropEvent
import net.minestom.server.event.player.PlayerBlockPlaceEvent
import net.minestom.server.event.player.PlayerStartDiggingEvent
import net.minestom.server.event.player.PlayerSwapItemEvent
import net.minestom.server.event.player.PlayerUseItemEvent
import java.util.*

class ItemEvents {
    init {
        eventNode("item_events", EventFilter.ALL) {
            listen<PlayerStartDiggingEvent> l@{
                if (player.itemInMainHand.hasTag(ItemConstants.tag)) {
                    val item = Constants.items[player.itemInMainHand.getTag(ItemConstants.tag)] ?: return@l
                    isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.LEFT_CLICK_BLOCK))
                }
            }
            listen<PlayerUseItemEvent> l@{
                if (itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                    isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.RIGHT_CLICK_AIR))
                }
            }
            listen<PlayerBlockPlaceEvent> {
                player.inventory.getItemInHand(hand).getTag(ItemConstants.tag)?.let { tag ->
                    val item: ItemStack = Constants.items[tag] ?: return@let
                    isCancelled = item.blockInteract
                    item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.RIGHT_CLICK_BLOCK))
                }
            }
            listen<ItemDropEvent> l@{
                if (itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                    isCancelled = item.blockDrop
                    item.dropHandler?.invoke(item, player.uuid)
                }
            }
            listen<InventoryPreClickEvent> l@{
                mutableListOf(cursorItem, clickedItem).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        isCancelled = item.blockClick
                        item.clickHandler?.invoke(item, player.uuid)
                    }
                }
            }
            listen<PlayerSwapItemEvent> l@{
                mutableListOf(
                    mainHandItem, offHandItem
                ).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        isCancelled = item.blockClick
                        item.clickHandler?.invoke(item, player.uuid)
                    }
                }
            }
        }
    }
}