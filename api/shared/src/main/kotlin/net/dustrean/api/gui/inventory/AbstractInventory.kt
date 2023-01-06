package net.dustrean.api.gui.inventory

import net.dustrean.api.gui.BaseGui
import net.dustrean.api.item.UnassignedItemStack
import java.util.*

abstract class AbstractInventory(
    val uniqueId: UUID,
    val parent: BaseGui
) {

    abstract fun updateView()

    abstract fun close()

    abstract fun open()

    abstract fun updateTitle()

    abstract fun updateItem(slot: Int, itemStack: UnassignedItemStack)

}