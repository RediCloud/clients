package net.dustrean.api.minestom

import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.network.packet.server.SendablePacket

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