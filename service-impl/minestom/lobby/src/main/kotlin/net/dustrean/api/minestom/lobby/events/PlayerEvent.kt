package net.dustrean.api.minestom.lobby.events

import net.dustrean.api.minestom.events.listenEvent
import net.dustrean.api.minestom.getWorld
import net.dustrean.api.minestom.item.ItemConstants.minestom
import net.dustrean.api.minestom.lobby.register.ItemRegister
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSpawnEvent

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
        listenEvent<PlayerLoginEvent> {
            setSpawningInstance(getWorld("fallback")!!)
            player.respawnPoint = Pos(0.0, 3.0, 0.0)
        }
    }
}