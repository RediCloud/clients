package dev.redicloud.clients.velocity.events

import com.velocitypowered.api.event.PostOrder
import dev.redicloud.clients.velocity.plugin
import dev.redicloud.clients.velocity.proxy

inline fun <reified T> listenEvent(order: PostOrder = PostOrder.NORMAL, crossinline block: T.() -> Unit) =
    proxy.eventManager.register(plugin, T::class.java, order) {
        block(it)
    }

