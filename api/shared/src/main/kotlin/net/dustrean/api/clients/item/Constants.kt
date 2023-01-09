package net.dustrean.api.clients.item

import java.util.*

object Constants {

    val items = mutableMapOf<UUID, ItemStack>()

    fun ItemStack.register() {
        items[identifier] = this
    }

}