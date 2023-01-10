package net.dustrean.clients.minestom.lobby.events

import net.dustrean.clients.item.enums.Material
import net.minestom.server.item.Material as MinestomMaterial
import net.dustrean.clients.minestom.events.listenEvent
import net.dustrean.clients.minestom.getWorld
import net.dustrean.clients.minestom.item.ItemConstants.minestom
import net.dustrean.clients.minestom.item.ItemConstants.setItemStack
import net.dustrean.clients.minestom.lobby.register.ItemRegister
import net.kyori.adventure.text.Component
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.item.ItemStack

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
            player.inventory.setItemStack(1, ItemStack.builder(MinestomMaterial.COMPASS).displayName(Component.text("E")).build())
        }
        listenEvent<PlayerLoginEvent> {
            setSpawningInstance(getWorld("fallback")!!)
            player.respawnPoint = Pos(0.0, 3.0, 0.0)
        }
    }
}