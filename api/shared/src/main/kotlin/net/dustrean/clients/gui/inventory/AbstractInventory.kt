package net.dustrean.clients.gui.inventory

import net.dustrean.clients.gui.Gui
import net.dustrean.clients.item.UnassignedItemStack
import java.util.*

abstract class AbstractInventory(
    val uniqueId: UUID,
    val parent: Gui
) {

    val items = mutableMapOf<Int, UnassignedItemStack>()

    abstract suspend fun updateView()

    abstract fun close()

    abstract suspend fun open()

    abstract suspend fun updateTitle()

    abstract suspend fun updateItem(slot: Int, itemStack: UnassignedItemStack)

}