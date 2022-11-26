package net.dustrean.api.minestom

import net.dustrean.api.minestom.events.listenEvent
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.PlayerSkin
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSkinInitEvent
import net.minestom.server.instance.block.Block

fun main() {
    server.start("0.0.0.0", 25565)

    val instanceContainer = instanceManager.createInstanceContainer()
    instanceContainer.setGenerator {
        it.modifier().fillHeight(0, 40, Block.AMETHYST_BLOCK)
    }

    listenEvent<PlayerLoginEvent> {
        it.setSpawningInstance(instanceContainer)
        it.player.respawnPoint = Pos(200.0, 50.0, 200.0)
    }

    testCommand
    flyCommand
}