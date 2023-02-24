package dev.redicloud.clients.minestom.lobby.items

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import dev.redicloud.clients.gui.GuiType
import dev.redicloud.clients.gui.impl.BaseGui
import dev.redicloud.clients.item.UnassignedItemStack
import dev.redicloud.clients.item.enums.InteractType
import dev.redicloud.clients.item.enums.Material
import net.kyori.adventure.text.Component

object Navigator : UnassignedItemStack(material = { Material.COMPASS },
    properties = { mutableMapOf("index" to 0) },
    languageProvider = {
        {
            name = Component.text("§aNavigator")
            lore = mutableListOf(
                Component.text("§7Click to open the navigator")
            )
        }
    },
    blockClick = { true },
    blockInteract = { true },
    blockDrop = { true },
    interactHandler = l@{ _, uuid, type ->
        if (type.get() != InteractType.RIGHT_CLICK_AIR && type.get() != InteractType.RIGHT_CLICK_BLOCK) return@l false
        GlobalScope.launch { Navigator.gui.open(uuid) }
        return@l true
    }) {
    private val gui = BaseGui(GuiType.CHEST, 5) {
        {
            title = Component.text("§aNavigator")
        }
    }
}