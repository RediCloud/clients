package dev.redicloud.minestom.application

import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.extensions.ExtensionClassLoader
import net.minestom.server.instance.AnvilLoader
import net.minestom.server.instance.InstanceContainer
import net.minestom.server.instance.InstanceManager
import net.minestom.server.instance.block.Block
import net.minestom.server.network.packet.server.SendablePacket
import java.util.*

val server = MinecraftServer.init()
val eventHandler = MinecraftServer.getGlobalEventHandler()
val commandManager = MinecraftServer.getCommandManager()
val instanceManager = MinecraftServer.getInstanceManager()
val packetListenerManager = MinecraftServer.getPacketListenerManager()
val packetProcessor = MinecraftServer.getPacketProcessor()
val connectionManager = MinecraftServer.getConnectionManager()
val extensionManager = MinecraftServer.getExtensionManager()

val onlinePlayers
    get() = connectionManager.onlinePlayers.toList()

fun Collection<Player>.sendPacket(packet: SendablePacket) = forEach {
    it.sendPacket(packet)
}

fun UUID.getPlayer() = connectionManager.getPlayer(this)

val worlds: MutableMap<String, InstanceContainer> = mutableMapOf()

fun InstanceManager.createFallbackWorld(): InstanceContainer {
    val instance = createInstanceContainer()
    instance.setGenerator {
        it.modifier().fillHeight(0, 1, Block.GRASS_BLOCK)
    }
    worlds["fallback"] = instance
    return instance
}

fun InstanceManager.loadWorld(name: String) = createInstanceContainer(
    AnvilLoader(name)
).also { worlds[name] = it }

fun getWorld(name: String) = worlds[name]