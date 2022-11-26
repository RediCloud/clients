package net.dustrean.api.minestom.skin

import net.dustrean.api.minestom.events.listenEvent
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.event.player.PlayerSkinInitEvent

object SkinProvider {
    val skinInit = listenEvent<PlayerSkinInitEvent> {
        skin = PlayerSkin.fromUsername(player.username)
    }
}