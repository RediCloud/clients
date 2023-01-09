package net.dustrean.api.clients.item

import net.dustrean.api.item.enums.InteractType
import net.dustrean.api.item.enums.MaterialLike
import net.dustrean.api.language.component.item.ItemComponentProvider
import java.util.*

data class UnassignedItemStack(
    var material: (UUID) -> MaterialLike,
    var languageProvider: (UUID) -> ItemComponentProvider.() -> Unit,
    var amount: (UUID) -> Int = { 1 },
    var damage: (UUID) -> Int = { 0 },
    var unbreakable: (UUID) -> Boolean = { false },
    var blockDrop: (UUID) -> Boolean = { false },
    var blockInteract: (UUID) -> Boolean = { false },
    var blockClick: (UUID) -> Boolean = { false },
    var dropHandler: ((ItemStack, UUID) -> Boolean)? = null,
    var interactHandler: ((ItemStack, UUID, Optional<InteractType>) -> Boolean)? = null,
    var clickHandler: ((ItemStack, UUID) -> Boolean)? = null,
    var permission: (UUID) -> String? = { null },
    var skullOwner: (UUID) -> UUID? = { null },
    var skullTexture: (UUID) -> String? = { null },
    var properties: (UUID) -> MutableMap<Any, Any> = { mutableMapOf() }
) {
    fun assign(playerUniqueId: UUID): ItemStack = ItemStack(
        this,
        playerUniqueId,
        material(playerUniqueId),
        languageProvider(playerUniqueId),
        amount(playerUniqueId),
        damage(playerUniqueId),
        unbreakable(playerUniqueId),
        blockDrop(playerUniqueId),
        blockInteract(playerUniqueId),
        blockClick(playerUniqueId),
        UUID.randomUUID(),
        dropHandler,
        interactHandler,
        clickHandler,
        permission(playerUniqueId),
        skullOwner(playerUniqueId),
        skullTexture(playerUniqueId),
        properties(playerUniqueId)
    )
}