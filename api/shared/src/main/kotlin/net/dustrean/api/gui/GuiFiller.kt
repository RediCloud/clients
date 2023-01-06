package net.dustrean.api.gui

import net.dustrean.api.item.UnassignedItemStack

class GuiFiller(
    val itemStack: UnassignedItemStack,
    val slots: List<Int>,
    val force: Boolean = false
) {

    constructor(
        itemStack: UnassignedItemStack,
        vararg slots: Int,
        force: Boolean = false
    ) : this(itemStack, slots.toList(), force)


    constructor(
        itemStack: UnassignedItemStack,
        start: Int,
        end: Int,
        force: Boolean = false
    ) : this(itemStack, (start..end).toList(), force)

    constructor(
        itemStack: UnassignedItemStack,
        start: Int,
        end: Int,
        step: Int,
        force: Boolean = false
    ) : this(itemStack, (start..end step step).toList(), force)

}