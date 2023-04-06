package dev.redicloud.clients.minestom.lobby.items

import dev.redicloud.clients.gui.GuiType
import dev.redicloud.clients.gui.impl.BaseGui
import dev.redicloud.clients.item.UnassignedItemStack
import dev.redicloud.clients.item.enums.InteractType
import dev.redicloud.clients.item.enums.Material
import dev.redicloud.minestom.application.getPlayer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.coordinate.Pos

object Navigator : UnassignedItemStack(material = { Material.COMPASS },
    languageProvider = {
        {
            key = "lobby.navigator"
            name = Component.text().color(NamedTextColor.AQUA).append(Component.text("Navigator")).build()
            lore = mutableListOf(
                Component.text().color(NamedTextColor.GRAY).append(Component.text("Click to open the navigator"))
                    .build()
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
            key = "lobby.navigator"
            title = Component.text().color(NamedTextColor.AQUA).append(Component.text("Navigator")).build()
        }
    }.apply {
        setItem(5, UnassignedItemStack(material = { Material.NETHER_STAR },
            languageProvider = {
                {
                    key = "lobby.navigator.spawn"
                    name = Component.text().color(NamedTextColor.AQUA).append(Component.text("Spawn")).build()
                    lore = mutableListOf(
                        Component.text().color(NamedTextColor.GRAY).append(Component.text("Click to teleport"))
                            .build()
                    )
                }
            },
            blockClick = { true },
            blockInteract = { true },
            blockDrop = { true },
            clickHandler = { _, uuid ->
                uuid.getPlayer()!!.teleport(Pos(0.0, 1.2, 0.0))
                uuid.getPlayer()!!.closeInventory()
                true
            }
        ))
    }
}