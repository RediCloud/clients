package net.dustrean.api.inventory.factory.impl

import net.dustrean.api.inventory.Inventory
import net.dustrean.api.item.ItemStackLike

@Suppress("MemberVisibilityCanBePrivate")
class DataInventoryFactory(var layout: Inventory) {
    var emptyLayout: Inventory? = null
        get() = field ?: layout

    var defaultComparator: Comparator<ItemStackLike>? = null
    fun get(list: Collection<ItemStackLike>, comparator: Comparator<ItemStackLike> = defaultComparator!!): Inventory {
        return if (list.isNotEmpty()) {
            val layout = layout.clone()
            list.sortedWith(comparator).forEach {
                layout.add(it)
            }
            layout
        } else emptyLayout!!
    }
}