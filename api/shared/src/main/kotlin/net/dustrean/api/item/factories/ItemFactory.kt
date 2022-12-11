package net.dustrean.api.item.factories

import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.ItemStackLike
import net.dustrean.api.item.enums.Material
import net.dustrean.api.item.factories.impl.DefaultItemFactory
import net.dustrean.api.item.factories.impl.DynamicItemFactory
import java.util.*

interface ItemFactory {
    fun create(): ItemStackLike
}

inline fun item(material: Material, crossinline apply: DefaultItemFactory.() -> Unit): ItemStack {
    return DefaultItemFactory(material).apply(apply).create()
        .get(null) // null because we don't need a player for customization.
}

inline fun dynamicItem(
    noinline material: (UUID?) -> Material,
    crossinline apply: DynamicItemFactory.() -> Unit
): ItemStackLike {
    return DynamicItemFactory(material).apply(apply)
}