package net.dustrean.clients.minestom.item

import net.dustrean.api.ICoreAPI
import net.dustrean.api.language.component.item.ItemComponentProvider
import net.dustrean.api.language.placeholder.PlaceholderProvider
import net.dustrean.clients.item.Constants.register
import net.dustrean.clients.item.ItemStack
import net.dustrean.clients.item.ItemStackLike
import net.minestom.server.entity.Player
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.inventory.PlayerInventory
import net.minestom.server.item.ItemMeta
import net.minestom.server.item.Material
import net.minestom.server.item.metadata.PlayerHeadMeta
import net.minestom.server.tag.Tag
import java.util.*
import net.minestom.server.item.ItemStack as MinestomItemStack
import net.minestom.server.item.Material as MinestomMaterial

object ItemConstants {

    private val languageManager = ICoreAPI.INSTANCE.languageManager
    val tag = Tag.UUID("item_api")
    suspend fun ItemStack.minestom(): MinestomItemStack {
        fun ItemMeta.Builder.applyData() {
            damage(this@minestom.damage)
            unbreakable(this@minestom.unbreakable)
            if (blockInteract) canPlaceOn(mutableSetOf())
        }

        val provider = ItemComponentProvider().apply(languageProvider)
        val placeholderProvider = PlaceholderProvider().apply(provider.placeholderProvider)
        val player = ICoreAPI.INSTANCE.playerManager.getPlayerByUUID(playerUniqueId)!!
        val languageId = languageManager.getLanguage(player.languageId)?.id ?: languageManager.getDefaultLanguage().id
        val component = languageManager.getItem(languageId, provider)

        val itemStack = MinestomItemStack.builder(
            MinestomMaterial.fromNamespaceId(material.getNameKey())
                ?: throw IllegalArgumentException("Material ${material.getNameKey()} is not supported by Minestom")
        ).amount(amount).lore(component.rawLore.map {
            languageManager.deserialize(it, component.serializerType, placeholderProvider.parse(it))
        }).displayName(
            languageManager.deserialize(
                component.rawName, component.serializerType, placeholderProvider.parse(component.rawName)
            )
        ).apply {
            if (material == Material.PLAYER_HEAD) {
                meta(PlayerHeadMeta.Builder().apply am@{
                    applyData()
                    skullOwner(skullOwner ?: UUID.randomUUID()) //required when not set, but textureURL is set
                    playerSkin(
                        if (this@minestom.skullTexture != null) PlayerSkin(
                            this@minestom.skullTexture, ""
                        )
                        else PlayerSkin.fromUuid(skullOwner?.toString() ?: return@am)
                    )
                }.build())
            } else meta {
                it.applyData()
            }.build()
        }.set(tag, identifier).build()
        register()
        return itemStack
    }

    fun MinestomItemStack?.getItemStack(): ItemStack? = net.dustrean.clients.item.Constants.items[this?.getTag(tag)]

    suspend fun Player.setItemStack(slot: Int, itemStack: ItemStackLike) {
        inventory.setItemStack(slot, itemStack.get(uuid).minestom())
    }

    //TODO: impl to inventory api
}