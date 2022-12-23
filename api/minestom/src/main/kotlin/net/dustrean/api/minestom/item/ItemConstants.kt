package net.dustrean.api.minestom.item

import net.dustrean.api.item.ItemStack
import net.dustrean.api.item.ItemStackLike
import net.dustrean.api.item.enums.Material
import net.minestom.server.entity.Player
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.inventory.AbstractInventory
import net.minestom.server.item.ItemMeta
import net.minestom.server.item.metadata.PlayerHeadMeta
import net.minestom.server.tag.Tag
import java.util.*
import net.minestom.server.item.ItemStack as MinestomItemStack
import net.minestom.server.item.Material as MinestomMaterial

object ItemConstants {
    val tag = Tag.UUID("item_api")
    fun ItemStack.minestom(): MinestomItemStack {
        fun ItemMeta.Builder.applyData() {
            damage(this@minestom.damage)
            unbreakable(this@minestom.unbreakable)
            if (blockInteract) canPlaceOn(mutableSetOf())
        }

        val itemStack = MinestomItemStack.builder(
            MinestomMaterial.fromId(material.id) ?: throw NullPointerException("Invalid Item ID")
        ).amount(amount).lore(lore).displayName(name).apply {
            if (material == Material.PLAYER_HEAD)
                meta(PlayerHeadMeta.Builder().apply am@{
                    applyData()
                    skullOwner(skullOwner ?: UUID.randomUUID()) //required when not set, but textureURL is set
                    playerSkin(
                        if (this@minestom.skullTexture != null)
                            PlayerSkin(
                                this@minestom.skullTexture,
                                ""
                            )
                        else PlayerSkin.fromUuid(skullOwner?.toString() ?: return@am)
                    )
                }.build())
            else meta {
                it.applyData()
            }
        }.set(tag, identifier).build()
        return itemStack
    }

    fun AbstractInventory.setItemStack(slot: Int, itemStack: ItemStack) {
        setItemStack(slot, itemStack.minestom())
    }

    fun Player.setItemStack(slot: Int, itemStack: ItemStackLike) {
        inventory.setItemStack(slot, itemStack.get(uuid))
    }
}