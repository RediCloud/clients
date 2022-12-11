package net.dustrean.api.item

import java.util.*

object Constants {
    val items: MutableMap<UUID, ItemStack> = mutableMapOf()
    fun ItemStack.register(uuid: UUID) {
        items.putIfAbsent(uuid, this) ?: return
        throw IllegalArgumentException("UUID already exists")
    }
}