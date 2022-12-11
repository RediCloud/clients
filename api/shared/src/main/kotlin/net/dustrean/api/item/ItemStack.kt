package net.dustrean.api.item

import net.dustrean.api.item.enums.InteractType
import net.dustrean.api.item.enums.Material
import net.kyori.adventure.text.Component
import java.util.*

/**
 * A Cross-platform Itemstack, which also makes creation and customization of items easier.
 */
data class ItemStack(
    var material: Material,
    /**
     * The name of the item.
     * When set to null, the name will be the default name of the item (mostly, will be decided by the platform)
     * @see net.kyori.adventure.text.Component
     */
    var name: Component?,
    /**
     * The amount of the item.
     * When set to 0, the item will not exist when added to an inventory.
     */
    var amount: Int,
    /**
     * The damage to the item.
     * When the item isn't damageable, this will be ignored.
     */
    var damage: Int,
    /**
     * The lore of the item.
     * @see net.kyori.adventure.text.Component
     */
    var lore: MutableList<Component>,
    /**
     * The unbreakable state of the item.
     * When the item isn't damageable, this will be ignored.
     */
    var unbreakable: Boolean,
    /**
     * This defines, if a user can drop this item out of their inventory.
     */
    var blockDrop: Boolean,
    /**
     * This defines, if a user can interact with this item using their hand.
     */
    var blockInteract: Boolean,
    /**
     * This defines, if a user can move the item in their inventory. (dragging, moving, swapping)
     * This includes other inventories as well.
     */
    var blockClick: Boolean,
    /**
     * Unique runtime identifier.
     * This is used to get the item from a serialized ItemStack.
     * When creating your own runtime, make sure to make a Map where you store its identifier.
     */
    val identifier: UUID,
    /**
     * When dropped, the given function will be called, providing the current item + the users uuid.
     */
    var dropHandler: ((ItemStack, UUID) -> Unit)?,
    /**
     * When interacted with, the given function will be called, providing the current item + the users uuid.
     */
    var interactHandler: ((ItemStack, UUID, Optional<InteractType>) -> Unit)?,
    /**
     * When moved in an inventory, the given function will be called, providing the current item + the users uuid.
     */
    var clickHandler: ((ItemStack, UUID) -> Unit)?,
    /**
     * Defines the permission a user needs to have this item set into their inventory.
     * When set to null, this will be ignored.
     */
    var permission: String?,
    /**
     * When set and the material is [Material.PLAYER_HEAD], this will be used as the texture of the skull.
     * <br>
     *
     * This is not recommended to use, as the player has to have joined the server before.
     * Use skull textures instead, which can be parsed by the Minecraft Texture API.
     * @see <a href="https://wiki.vg/Mojang_API#UUID_to_Profile_and_Skin.2FCape">Minecraft API texture URL</a>
     * @see[skullTexture]
     */
    var skullOwner: UUID? = null,
    /**
     * When set and the material is [Material.PLAYER_HEAD], this will be used as the texture of the skull.
     *
     * This is usually decoded in a base64 string, but when provided with a URL, it will be automatically decoded.
     * @see[skullOwner]
     */
    var skullTexture: String? = null,
    /**
     * Internal map for custom data.
     * This is used to store custom data, which can be retrieved later.
     */
    var properties: Map<Any, Any>
) : ItemStackLike {
    override fun get(uuid: UUID?): ItemStack = this
}
