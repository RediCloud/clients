package net.dustrean.api.minestom.events

import net.dustrean.api.minestom.eventHandler
import net.minestom.server.event.Event

inline fun <reified T : Event> listenEvent(crossinline block: (event: T) -> Unit) {
    eventHandler.addListener(T::class.java) { block(it) }
}