package net.dustrean.api.clients.minestom.events

import net.dustrean.api.clients.minestom.eventHandler
import net.minestom.server.event.Event
import net.minestom.server.event.EventFilter
import net.minestom.server.event.EventNode

inline fun <reified T : Event> listenEvent(crossinline block: T.() -> Unit) {
    eventHandler.addListener(T::class.java) { block(it) }
}

inline fun <reified T : Event> EventNode<Event>.listen(crossinline block: T.() -> Unit) {
    addListener(T::class.java) { block(it) }
}

inline fun <reified T : Event> eventNode(
    name: String,
    filter: EventFilter<T, *>,
    crossinline block: EventNode<T>.() -> Unit
) {
    eventHandler.addChild(EventNode.type(name, filter).apply(block))
}