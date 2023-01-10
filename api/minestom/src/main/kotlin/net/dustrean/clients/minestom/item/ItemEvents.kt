package net.dustrean.clients.minestom.item

import net.dustrean.clients.item.Constants
import net.dustrean.clients.item.ItemStack
import net.dustrean.clients.item.enums.InteractType
import net.dustrean.clients.minestom.events.eventNode
import net.dustrean.clients.minestom.events.listen
import net.minestom.server.event.EventFilter
import net.minestom.server.event.inventory.InventoryPreClickEvent
import net.minestom.server.event.item.ItemDropEvent
import net.minestom.server.event.player.*
import net.minestom.server.utils.block.BlockIterator
import java.util.*

class ItemEvents {
    init {
        eventNode("item_events", EventFilter.ALL) {
            listen<PlayerStartDiggingEvent> l@{
                if (player.itemInMainHand.hasTag(ItemConstants.tag)) {
                    val item = Constants.items[player.itemInMainHand.getTag(ItemConstants.tag)] ?: return@l
                    val cancel = item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.LEFT_CLICK_BLOCK))
                    if(cancel == true || item.blockInteract) isCancelled = true
                }
            }
            listen<PlayerUseItemEvent> l@{
                if (itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                    val cancel = item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.RIGHT_CLICK_AIR))
                    if(cancel == true || item.blockInteract) isCancelled = true
                }
            }
            listen<PlayerBlockPlaceEvent> {
                player.inventory.getItemInHand(hand).getTag(ItemConstants.tag)?.let { tag ->
                    val item: ItemStack = Constants.items[tag] ?: return@let
                    val cancel = item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.RIGHT_CLICK_BLOCK))
                    if(cancel == true || item.blockInteract) isCancelled = true
                }
            }
            listen<ItemDropEvent> l@{
                if (itemStack.hasTag(ItemConstants.tag)) {
                    val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                    val cancel = item.dropHandler?.invoke(item, player.uuid)
                    if(cancel == true || item.blockDrop) isCancelled = true
                }
            }
            listen<InventoryPreClickEvent> l@{
                mutableListOf(cursorItem, clickedItem).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        val cancel = item.clickHandler?.invoke(item, player.uuid)
                        if(cancel == true || item.blockClick) isCancelled = true
                    }
                }
            }
            listen<PlayerSwapItemEvent> l@{
                mutableListOf(
                    mainHandItem, offHandItem
                ).forEach { itemStack ->
                    if (itemStack.hasTag(ItemConstants.tag)) {
                        val item: ItemStack = Constants.items[itemStack.getTag(ItemConstants.tag)] ?: return@l
                        val cancel = item.clickHandler?.invoke(item, player.uuid)
                        if(cancel == true || item.blockClick) isCancelled = true
                    }
                }
            }
            listen<PlayerHandAnimationEvent> l@{
                val itemStack =
                    player.itemInMainHand.takeUnless { it.isAir || it.getTag(ItemConstants.tag) == null } ?: return@l
                try {
                    BlockIterator(
                        this.player, 5
                    ).forEachRemaining {
                        if (player.instance?.getBlock(it)?.isAir == false || player.instance?.getNearbyEntities(it, 0.2)
                                ?.isEmpty() == false
                        ) throw IllegalAccessException()
                    }
                } catch (e: IllegalAccessException) {
                    return@l
                }
                itemStack.getTag(ItemConstants.tag)?.let { tag ->
                    val item: ItemStack = Constants.items[tag] ?: return@l
                    val cancel = item.interactHandler?.invoke(item, player.uuid, Optional.of(InteractType.LEFT_CLICK_AIR))
                    if(cancel == true || item.blockInteract) isCancelled = true
                }
            }
        }
    }
}