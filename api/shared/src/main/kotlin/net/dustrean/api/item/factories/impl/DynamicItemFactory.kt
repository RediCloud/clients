package net.dustrean.api.item.factories.impl

import net.dustrean.api.item.Constants
import net.dustrean.api.item.Constants.register
import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.ItemStackLike
import net.dustrean.api.item.enums.InteractType
import net.dustrean.api.item.enums.Material
import net.dustrean.api.item.factories.ItemFactory
import net.kyori.adventure.text.Component
import java.util.*

class DynamicItemFactory(var material: (UUID?) -> Material) : ItemFactory, ItemStackLike {
    var name: (UUID?) -> Component? = { null }
    var amount: (UUID?) -> Int = { 1 }
    var damage: (UUID?) -> Int = { 0 }
    var lore: (UUID?) -> MutableList<Component> = { mutableListOf() }
    var unbreakable: (UUID?) -> Boolean = { false }
    var blockDrop: (UUID?) -> Boolean = { false }
    var blockInteract: (UUID?) -> Boolean = { false }
    var blockClick: (UUID?) -> Boolean = { false }
    var dropHandler: ((ItemStack, UUID) -> Unit)? = null
    var interactHandler: ((ItemStack, UUID, Optional<InteractType>) -> Unit)? = null
    var clickHandler: ((ItemStack, UUID) -> Unit)? = null
    var permission: (UUID?) -> String? = { null }
    var skullOwner: (UUID?) -> UUID? = { null }
    var skullTexture: (UUID?) -> String? = { null }
    var properties: (UUID?) -> MutableMap<Any, Any> = { mutableMapOf() }
    override fun create(): ItemStackLike =
        create(null)

    fun create(uuid: UUID?): ItemStackLike {
        var identifier = UUID.randomUUID()
        while (Constants.items.containsKey(identifier)) {
            identifier = UUID.randomUUID()
        }
        return ItemStack(
            material(uuid),
            name(uuid),
            amount(uuid),
            damage(uuid),
            lore(uuid),
            unbreakable(uuid),
            blockDrop(uuid),
            blockInteract(uuid),
            blockClick(uuid),
            identifier,
            dropHandler,
            interactHandler,
            clickHandler,
            permission(uuid),
            skullOwner(uuid),
            skullTexture(uuid),
            properties(uuid)
        )
    }

    override fun get(uuid: UUID?): ItemStack {
        return (create(uuid) as ItemStack).apply { register(identifier) }
    }

}