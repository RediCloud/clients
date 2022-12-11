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

@Suppress("MemberVisibilityCanBePrivate")
class DefaultItemFactory(
    var material: Material
) : ItemFactory, ItemStackLike {
    var name: Component? = null
    var amount: Int = 1
    var damage: Int = 0
    var lore: MutableList<Component> = mutableListOf()
    var unbreakable: Boolean = false
    var blockDrop: Boolean = false
    var blockInteract: Boolean = false
    var blockClick: Boolean = false


    var blockAll: Boolean = false
        set(value) {
            blockDrop = value
            blockInteract = value
            blockClick = value
            field = value
        }

    var dropHandler: ((ItemStack, UUID) -> Unit)? = null
    var interactHandler: ((ItemStack, UUID, Optional<InteractType>) -> Unit)? = null
    var clickHandler: ((ItemStack, UUID) -> Unit)? = null
    var permission: String? = null
    var skullOwner: UUID? = null
    var skullTexture: String? = null
        set(value) {
            field = when {
                value == null -> null
                "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?\$".toRegex().matches(value) -> value
                "\\{.*\"textures\":\\{.*\"SKIN\":\\{.*\"url\":\".*\".*}.*}.*}".toRegex()
                    .matches(value) -> Base64.getEncoder().encode(value.toByteArray()).decodeToString()

                else -> Base64.getEncoder().encode("{\"textures\": {\"SKIN\": {\"url\": \"$value\"}}}".toByteArray())
                    .decodeToString()
            }
        }
    var properties: MutableMap<Any, Any> = mutableMapOf()
    override fun create(): ItemStack {
        var uuid = UUID.randomUUID()
        while (Constants.items.containsKey(uuid)) {
            uuid = UUID.randomUUID()
        }
        return ItemStack(
            material,
            name,
            amount,
            damage,
            lore,
            unbreakable,
            blockDrop,
            blockInteract,
            blockClick,
            uuid,
            dropHandler,
            interactHandler,
            clickHandler,
            permission,
            skullOwner,
            skullTexture,
            properties
        ).apply {
            register(identifier)
        }
    }

    override fun get(uuid: UUID?): ItemStack =
        create().apply { register(identifier) }

}