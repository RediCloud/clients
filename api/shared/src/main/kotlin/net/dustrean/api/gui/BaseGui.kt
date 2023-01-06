package net.dustrean.api.gui

import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.UnassignedItemStack
import net.dustrean.api.language.component.inventory.InventoryComponentProvider
import java.util.UUID

class BaseGui(
    val type: GuiType,
    val rows: Int = type.rows,
    val languageProvider: (UUID) -> InventoryComponentProvider.() -> Unit
) {

    private val items = mutableMapOf<Int, UnassignedItemStack>()
    private val slotActions = mutableMapOf<Int, (UUID, ItemStack?) -> Unit>()
    val fillers = mutableListOf<GuiFiller>()
    val outSideClickAction: ((UUID, ItemStack?) -> Unit)? = null
    val dragAction: ((UUID, ItemStack?) -> Unit)? = null
    val closeAction: ((UUID, ItemStack?) -> Unit)? = null
    val openAction: ((UUID, ItemStack?) -> Unit)? = null

    suspend fun open(uniqueId: UUID){
        val built = InventoryComponentProvider().apply(languageProvider.invoke(uniqueId))
    }

    fun getItem(slot: Int) = items[slot]
    fun setItem(slot: Int, item: UnassignedItemStack) {
        items[slot] = item
    }
    fun removeItem(slot: Int) = items.remove(slot)


    fun getSlotAction(slot: Int) = slotActions[slot]
    fun setSlotAction(slot: Int, action: (UUID, ItemStack?) -> Unit) {
        slotActions[slot] = action
    }
    fun removeSlotAction(slot: Int) = slotActions.remove(slot)

}