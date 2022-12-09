package net.dustrean.api.minestom

import net.dustrean.api.minestom.events.listenEvent
import net.dustrean.api.minestom.utils.env
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.extras.MojangAuth
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy
import net.minestom.server.instance.block.Block

fun main() {
    server
    MojangAuth.init()

    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    server.start("0.0.0.0", env("service.bind.port").toInt())
    if (extensionManager.extensions.isEmpty()) {
        val instance = instanceManager.createInstanceContainer().apply {
            this.setGenerator {
                it.modifier().fillHeight(0, 1, Block.GRASS_BLOCK)
            }
        }
        listenEvent<PlayerLoginEvent> {
            setSpawningInstance(instance)
            player.respawnPoint = Pos(0.0, 2.0, 0.0)
        }
    }
}