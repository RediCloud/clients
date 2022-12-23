package net.dustrean.api.inventory

import net.dustrean.api.item.ItemStackLike
import net.kyori.adventure.text.Component
import java.util.*

interface Inventory {
    var lines: Int
    var name: (UUID) -> Component
    var items: MutableMap<Int, ItemStackLike>

    fun add(item: ItemStackLike)

    fun clone(): Inventory
}