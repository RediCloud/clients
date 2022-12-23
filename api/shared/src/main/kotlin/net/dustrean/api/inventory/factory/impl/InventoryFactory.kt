package net.dustrean.api.inventory.factory.impl

import net.dustrean.api.item.ItemStackLike
import net.dustrean.api.inventory.Inventory
import net.dustrean.api.item.ItemStack
import net.kyori.adventure.text.Component
import java.util.*

class InventoryFactory(override var lines: Int, override var name: (UUID) -> Component) : Inventory {
    constructor(lines: Int, name: Component) : this(lines, { name })

    init {
        require(lines in 1..6) { "Inventory lines must be between 1 and 6." }
    }

    override var items: MutableMap<Int, ItemStackLike> = mutableMapOf()
    var border: ItemStackLike? = null
        set(value) {
            field = value
            if (value == null) return
            for (i in 0 until lines * 9) {
                if (i % 9 == 0 || i % 9 == 8 || i < 9 || i > lines * 9 - 9) {
                    items[i] = value
                }
            }
        }

    operator fun set(i: Int, item: ItemStackLike) {
        items[i] = item
    }

    operator fun Int.plusAssign(item: ItemStackLike) {
        items[this] = item
    }

    operator fun Int.plus(item: ItemStackLike) {
        items[this] = item
    }

    operator fun ItemStack.get(range: IntRange) {
        items.putAll(range.map {
            it to this
        })
    }

    override fun add(item: ItemStackLike) {
        var i = 0
        while (items.containsKey(i)) {
            i++
        }
        items[i] = item
    }

    override fun clone(): Inventory = InventoryFactory(lines, name).apply {
        items = this@InventoryFactory.items.toMutableMap()
    }
}
