package dev.redicloud.clients.gui.impl

import dev.redicloud.clients.Clients
import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiType
import dev.redicloud.clients.item.ItemStack
import dev.redicloud.clients.item.UnassignedItemStack
import dev.redicloud.api.language.component.inventory.InventoryComponentProvider
import java.util.*

class BaseGui(
    type: GuiType,
    rows: Int = type.rows,
    languageProvider: (UUID) -> InventoryComponentProvider.() -> Unit
) : Gui(type, rows, languageProvider){

    private val items = mutableMapOf<Int, UnassignedItemStack>()
    private val slotActions = mutableMapOf<Int, (UUID, ItemStack?) -> Boolean>()

    fun getItem(slot: Int) = items[slot]
    fun setItem(slot: Int, item: UnassignedItemStack) {
        items[slot] = item
    }
    fun setItem(row: Int, column: Int, item: UnassignedItemStack) = setItem(calculateSlot(row, column), item)
    fun removeItem(slot: Int) = items.remove(slot)
    fun removeItem(row: Int, column: Int) = removeItem(row * 9 + column)

    fun getSlotAction(slot: Int) = slotActions[slot]
    fun setSlotAction(slot: Int, action: (UUID, ItemStack?) -> Boolean) {
        slotActions[slot] = action
    }
    fun setSlotAction(row: Int, column: Int, action: (UUID, ItemStack?) -> Boolean) = setSlotAction(calculateSlot(row, column), action)
    fun removeSlotAction(slot: Int) = slotActions.remove(slot)
    fun removeSlotAction(row: Int, column: Int) = removeSlotAction(calculateSlot(row, column))

    suspend fun open(uniqueID: UUID) {
        val inventory = Clients.INSTANCE.guiProvider.createInventory(uniqueID, this)
        inventories[uniqueID] = inventory
        items.forEach { (slot, unassignedItemStack) ->
            inventory.items[slot] = unassignedItemStack
        }
        inventory.open()
    }

    override suspend fun update(uniqueId: UUID) {
        if(inventories.containsKey(uniqueId)) {
            val inventory = inventories[uniqueId]!!
            inventory.items.clear()
            items.forEach { (slot, unassignedItemStack) ->
                inventory.items[slot] = unassignedItemStack
            }
            super.update(uniqueId)
        }
        super.update()
    }

    private fun calculateSlot(row: Int, column: Int): Int {
        if (row > rows || row < 1) throw IllegalArgumentException("Row must be less than or equal to $rows")
        if (column > type.rowSize || column < 1) throw IllegalArgumentException("Column must be less than or equal to ${type.rowSize}")
        return (row - 1) * type.rowSize + (column - 1)
    }

}