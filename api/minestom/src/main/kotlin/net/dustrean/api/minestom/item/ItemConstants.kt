package net.dustrean.api.minestom.item

import net.dustrean.api.minestom.item.Constants.register
import net.dustrean.api.minestom.item.enums.Material
import net.kyori.adventure.key.Key
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.item.ItemMeta
import net.minestom.server.item.metadata.PlayerHeadMeta
import net.minestom.server.tag.Tag
import java.util.*
import net.minestom.server.item.ItemStack as MinestomItemStack
import net.minestom.server.item.Material as MinestomMaterial

object ItemConstants {
    val tag = Tag.UUID("item_api")
    fun ItemStack.toMinestomItemStack(): MinestomItemStack {
        fun ItemMeta.Builder.applyData() {
            damage(this@toMinestomItemStack.damage)
            unbreakable(this@toMinestomItemStack.unbreakable)
            if (blockInteract) canPlaceOn(mutableSetOf())
        }
        val itemStack = MinestomItemStack.builder(
            MinestomMaterial.fromId(material.id) ?: throw NullPointerException("Invalid Item ID")
        ).amount(amount).lore(lore).displayName(name).apply {
            if (material == Material.PLAYER_HEAD)
                meta(PlayerHeadMeta.Builder().apply {
                    applyData()
                    skullOwner(skullOwner ?: UUID.randomUUID()) //required when not set, but textureURL is set
                    playerSkin(
                        if (this@toMinestomItemStack.skullTexture != null)
                        PlayerSkin(
                            this@toMinestomItemStack.skullTexture,
                            ""
                        )
                        else PlayerSkin.fromUuid(skullOwner?.toString() ?: return@apply)
                    )
                }.build())
            else meta {
                it.applyData()
            }
        }.set(tag, identifier).build()
        return itemStack
    }
}