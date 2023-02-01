package net.dustrean.clients.item

import java.util.*

interface ItemStackLike {
    fun get(playerUniqueId: UUID): ItemStack
}