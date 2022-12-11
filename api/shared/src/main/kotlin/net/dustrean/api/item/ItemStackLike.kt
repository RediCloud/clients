package net.dustrean.api.item

import java.util.*

interface ItemStackLike {
    fun get(uuid: UUID? = null): ItemStack
}