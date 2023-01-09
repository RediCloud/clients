package net.dustrean.api.clients.paper

import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

lateinit var plugin: JavaPlugin

inline fun <reified T : Event> listenEvent(
    order: EventPriority = EventPriority.NORMAL,
    crossinline block: T.() -> Unit
) =
    Bukkit.getPluginManager().registerEvent(T::class.java, object : Listener {}, order, { listener, event ->
        (event as T).block()
    }, plugin, false)