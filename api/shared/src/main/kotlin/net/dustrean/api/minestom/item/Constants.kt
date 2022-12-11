package net.dustrean.api.minestom.item

import net.dustrean.api.minestom.item.enums.Material
import net.dustrean.api.minestom.item.factories.impl.DefaultItemFactory
import net.dustrean.api.minestom.item.factories.impl.DynamicItemFactory
import net.dustrean.api.minestom.scoreboard.factories.ScoreboardFactory
import java.util.*

object Constants {
    val items: MutableMap<UUID, ItemStack> = mutableMapOf()
    fun ItemStack.register(uuid: UUID) {
        items.putIfAbsent(uuid, this) ?: return
        throw IllegalArgumentException("UUID already exists")
    }

    inline fun item(material: Material, crossinline apply: DefaultItemFactory.() -> Unit): ItemStack {
        return DefaultItemFactory(material).apply(apply).create()
            .get(null) // null because we don't need a player for customization.
    }

    inline fun dynamicItem(noinline material: (UUID?) -> Material, crossinline apply: DynamicItemFactory.() -> Unit): ItemStackLike {
        return DynamicItemFactory(material).apply(apply)
    }

    inline fun scoreboard(crossinline init: ScoreboardFactory.() -> Unit): ScoreboardFactory {
        return ScoreboardFactory().apply(init)
    }
}