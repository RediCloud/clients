package net.dustrean.api.item

import java.util.*

interface ItemStackLike {
    fun get(playerUniqueId: UUID): ItemStack
}