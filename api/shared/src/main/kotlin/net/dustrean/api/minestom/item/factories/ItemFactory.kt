package net.dustrean.api.minestom.item.factories

import net.dustrean.api.minestom.item.ItemStackLike

interface ItemFactory {
    fun create(): ItemStackLike
}