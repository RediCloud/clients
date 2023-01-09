package net.dustrean.api.clients.item

import java.util.*

interface ItemStackLike {
    fun get(playerUniqueId: UUID): ItemStack
}