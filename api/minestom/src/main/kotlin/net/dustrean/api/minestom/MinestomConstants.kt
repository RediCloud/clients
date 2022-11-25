package net.dustrean.api.minestom

import net.minestom.server.MinecraftServer

val server = MinecraftServer.init()
val eventHandler = MinecraftServer.getGlobalEventHandler()
val commandManager = MinecraftServer.getCommandManager()
val instanceManager = MinecraftServer.getInstanceManager()