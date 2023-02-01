package net.dustrean.clients.minestom.lobby.events

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dustrean.clients.minestom.events.listenEvent
import net.dustrean.clients.minestom.getWorld
import net.dustrean.clients.minestom.item.ItemConstants.setItemStack
import net.dustrean.clients.minestom.lobby.items.Navigator
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSpawnEvent

class PlayerEvent {

    init {
        listenEvent<PlayerSpawnEvent> {
            if (!isFirstSpawn) return@listenEvent
            GlobalScope.launch { player.setItemStack(0, Navigator.assign(player.uuid)) }
        }
        listenEvent<PlayerLoginEvent> {
            setSpawningInstance(getWorld("fallback")!!)
            player.respawnPoint = Pos(0.0, 3.0, 0.0)
        }
    }
}