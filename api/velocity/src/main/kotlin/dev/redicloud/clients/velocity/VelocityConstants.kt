package dev.redicloud.clients.velocity

import com.velocitypowered.api.plugin.PluginContainer
import com.velocitypowered.api.proxy.ProxyServer

lateinit var proxy: ProxyServer
lateinit var plugin: PluginContainer

val onlinePlayers
    get() = proxy.allPlayers.toList()