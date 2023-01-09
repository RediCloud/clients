package net.dustrean.api.clients.gui

import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.UnassignedItemStack
import java.util.*

class GuiFiller(
    val itemStack: UnassignedItemStack,
    val slots: List<Int>,
    val force: Boolean = false,
    val action: (UUID, ItemStack?) -> Boolean = { _, _ -> true }
) {

    constructor(
        itemStack: UnassignedItemStack,
        vararg slots: Int,
        force: Boolean = false,
        action: (UUID, ItemStack?) -> Boolean = { _, _ -> true }
    ) : this(itemStack, slots.toList(), force, action)

    constructor(
        itemStack: UnassignedItemStack,
        start: Int,
        end: Int,
        force: Boolean = false,
        action: (UUID, ItemStack?) -> Boolean = { _, _ -> true }
    ) : this(itemStack, (start..end).toList(), force, action)

    constructor(
        itemStack: UnassignedItemStack,
        start: Int,
        end: Int,
        step: Int,
        force: Boolean = false,
        action: (UUID, ItemStack?) -> Boolean = { _, _ -> true }
    ) : this(itemStack, (start..end step step).toList(), force, action)

}