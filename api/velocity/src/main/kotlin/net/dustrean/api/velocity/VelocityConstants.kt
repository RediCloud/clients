package net.dustrean.api.velocity

import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer

lateinit var proxy: ProxyServer
lateinit var plugin: Plugin

val onlinePlayers
    get() = proxy.allPlayers.toList()