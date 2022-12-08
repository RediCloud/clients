package net.dustrean.api.minestom.item

import net.dustrean.api.minestom.item.enums.Material
import net.dustrean.api.minestom.item.factories.impl.DefaultItemFactory
import net.dustrean.api.minestom.item.factories.impl.DynamicItemFactory
import java.util.*

object Constants {
    val items: MutableMap<UUID, ItemStack> = mutableMapOf()
    fun ItemStack.register(uuid: UUID) {
        items.putIfAbsent(uuid, this) ?: return
        throw IllegalArgumentException("UUID already exists")
    }
    fun item(material: Material, apply: DefaultItemFactory.() -> Unit): ItemStack {
        return DefaultItemFactory(material).apply(apply).create()
            .get(null) // null because we don't need a player for customization.
    }

    fun dynamicItem(material: (UUID?) -> Material, apply: DynamicItemFactory.() -> Unit): ItemStackLike {
        return DynamicItemFactory(material).apply(apply)
    }
}