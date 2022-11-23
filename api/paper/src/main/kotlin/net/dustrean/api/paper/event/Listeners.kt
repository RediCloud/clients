package net.dustrean.api.paper.event

import net.dustrean.api.paper.extensions.plugin
import net.dustrean.api.paper.extensions.pluginManager
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

fun Listener.unregisterAll() = HandlerList.unregisterAll(this)

abstract class KListener<T : Event>(
    val priority: EventPriority, val ignoreCancelled: Boolean
) : Listener {
    abstract fun onEvent(event: T)
}

inline fun <reified T : Event> KListener<T>.register() {
    pluginManager.registerEvent(
        T::class.java, this, priority, { _, event -> (event as? T)?.let { this.onEvent(it) } }, plugin, ignoreCancelled
    )
}

inline fun <reified T : Event> listenEvent(
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    register: Boolean = true,
    crossinline onEvent: (event: T) -> Unit,
): KListener<T> {
    val listener = object : KListener<T>(priority, ignoreCancelled) {
        override fun onEvent(event: T) = onEvent.invoke(event)
    }
    return listener.also { if (register) listener.register() }
}