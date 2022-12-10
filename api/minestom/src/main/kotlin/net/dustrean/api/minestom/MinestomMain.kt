package net.dustrean.api.minestom

import net.dustrean.api.minestom.events.listenEvent
import net.dustrean.api.minestom.item.Constants
import net.dustrean.api.minestom.item.ItemConstants.setItemStack
import net.dustrean.api.minestom.item.ItemEvents
import net.dustrean.api.minestom.item.enums.Material
import net.dustrean.api.minestom.utils.env
import net.kyori.adventure.text.Component
import net.minestom.server.command.builder.Command
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.extras.MojangAuth
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy
import net.minestom.server.instance.block.Block

fun main() {
    server
    MojangAuth.init()

    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    ItemEvents()
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
        commandManager.register(
            Command("hello").apply {
                setDefaultExecutor { sender, _ ->
                    sender !is Player && return@setDefaultExecutor
                    sender as Player // Smart cast
                    sender.sendMessage("Hello, ${sender.username}!")
                    sender.setItemStack(0, Constants.item(Material.STONE) {
                        this.amount = 69
                        this.name = Component.text("E")
                        this.lore = mutableListOf(Component.text("EA"))
                        this.blockAll = true
                        this.clickHandler = { _, uuid ->
                            uuid.getPlayer()?.sendMessage("CLICKED")
                        }
                        this.interactHandler = { _, uuid, optional ->
                            uuid.getPlayer()?.sendMessage("INTERACTED: ${optional.get()}")
                        }
                        this.dropHandler = { _, uuid ->
                            uuid.getPlayer()?.sendMessage("DROPPED")
                        }
                    })
                }
            }
        )
    }
}