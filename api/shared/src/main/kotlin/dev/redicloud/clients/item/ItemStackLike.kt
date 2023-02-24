package dev.redicloud.clients.item

import java.util.*

interface ItemStackLike {
    fun get(playerUniqueId: UUID): ItemStack
}