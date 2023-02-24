package dev.redicloud.clients.gui.inventory

import dev.redicloud.api.ICoreAPI
import dev.redicloud.api.language.component.inventory.InventoryComponentProvider
import dev.redicloud.api.language.placeholder.PlaceholderProvider
import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.item.UnassignedItemStack
import net.kyori.adventure.text.Component
import java.util.*

abstract class AbstractInventory(
    val uniqueId: UUID,
    val parent: Gui
) {

    val items = mutableMapOf<Int, UnassignedItemStack>()

    abstract suspend fun updateView()

    abstract fun close()

    abstract suspend fun open()

    abstract suspend fun updateTitle()

    abstract suspend fun updateItem(slot: Int, itemStack: UnassignedItemStack)

    suspend fun getTitle(): Component {
        val built = InventoryComponentProvider().apply(parent.languageProvider.invoke(uniqueId))
        val player = ICoreAPI.INSTANCE.playerManager.getPlayerByUUID(uniqueId)
            ?: throw IllegalStateException("Player not found")
        val langaugeId = ICoreAPI.INSTANCE.languageManager.getLanguage(player.languageId)?.id
            ?: ICoreAPI.INSTANCE.languageManager.getDefaultLanguage().id
        val provider = ICoreAPI.INSTANCE.languageManager.getInventory(langaugeId, built)
        return ICoreAPI.INSTANCE.languageManager.deserialize(
            provider.rawTitle,
            provider.serializerType,
            PlaceholderProvider().apply(built.placeholderProvider).parse(provider.rawTitle)
        )
    }

}