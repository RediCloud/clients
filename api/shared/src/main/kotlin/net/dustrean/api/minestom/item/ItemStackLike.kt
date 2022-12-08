package net.dustrean.api.minestom.item

import java.util.*

interface ItemStackLike {
    fun get(uuid: UUID? = null): ItemStack
}