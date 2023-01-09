package net.dustrean.api.clients.gui

import net.dustrean.api.gui.inventory.AbstractInventory
import net.dustrean.api.item.ItemStack
import net.dustrean.api.language.component.inventory.InventoryComponentProvider
import java.util.*

abstract class Gui(
    val type: GuiType, val rows: Int = type.rows, val languageProvider: (UUID) -> InventoryComponentProvider.() -> Unit
) {

    internal val inventories = mutableMapOf<UUID, AbstractInventory>()
    val fillers = mutableListOf<GuiFiller>()
    val outSideClickAction: ((UUID, ItemStack?) -> Boolean)? = null
    val dragAction: ((UUID, ItemStack?) -> Boolean)? = null
    val closeAction: ((UUID) -> Boolean)? = null
    val openAction: ((UUID) -> Boolean)? = null
    val interactionModifiers = mutableListOf<GuiInteractionModifier>()

    open suspend fun update() = inventories.forEach { update(it.key) }

    open suspend fun update(uniqueId: UUID) {
        if (!inventories.containsKey(uniqueId)) return
        val inventory = inventories[uniqueId]!!
        inventory.updateView()
        inventory.updateTitle()
    }

}