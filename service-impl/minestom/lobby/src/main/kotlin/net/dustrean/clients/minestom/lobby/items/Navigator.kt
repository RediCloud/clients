package net.dustrean.clients.minestom.lobby.items

import net.dustrean.clients.gui.factory.inventory
import net.dustrean.clients.item.ItemStackLike
import net.dustrean.clients.item.enums.InteractType
import net.dustrean.clients.item.enums.Material
import net.dustrean.clients.item.factories.dynamicItem
import net.dustrean.clients.minestom.gui.InventoryConstants.open
import net.dustrean.clients.minestom.lobby.LobbyExtension
import net.kyori.adventure.text.Component

object Navigator : ItemStackLike by dynamicItem(
    {
        Material.COMPASS
    }, {
        properties = {
            mutableMapOf("index" to 0)
        }
        name = { Component.text("§aNavigator") }
        lore = {
            mutableListOf(
                Component.text("§7Click to open the navigator")
            )
        }
        blockAll = true
        interactHandler = l@{ _, uuid, type ->
            if (type.get() != InteractType.RIGHT_CLICK_AIR && type.get() != InteractType.RIGHT_CLICK_BLOCK) return@l
            Navigator.inv.open(
                uuid
            )
        }
    }
) {
    private val inv = inventory(6, Component.text("§aNavigator")) {
        border = LobbyExtension.PLACEHOLDER
    }
}