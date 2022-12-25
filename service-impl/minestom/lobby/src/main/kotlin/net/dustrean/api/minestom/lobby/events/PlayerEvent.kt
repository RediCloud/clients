package net.dustrean.api.minestom.lobby.events

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.dustrean.api.minestom.events.listenEvent
import net.dustrean.api.minestom.item.ItemConstants.minestom
import net.dustrean.api.minestom.item.ItemConstants.setItemStack
import net.dustrean.api.minestom.lobby.register.ItemRegister
import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.network.packet.client.play.ClientAnimationPacket
import net.minestom.server.network.packet.server.play.EntityAnimationPacket

class PlayerEvent {

    init {
        listenEvent<PlayerSpawnEvent> {
            if (!isFirstSpawn) return@listenEvent
            // TODO() CHECK LOGIN
            for (item in ItemRegister.get(player.uuid)) {
                item.invokeOnCompletion {
                    val completed = item.getCompleted()
                    player.inventory.setItemStack(completed.properties["index"] as Int, completed.minestom())
                }
            }
        }
    }
}