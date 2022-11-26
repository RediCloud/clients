package net.dustrean.api.velocity.events

import com.velocitypowered.api.event.PostOrder
import net.dustrean.api.velocity.plugin
import net.dustrean.api.velocity.proxy

inline fun <reified T> listenEvent(order: PostOrder = PostOrder.NORMAL, crossinline block: T.() -> Unit) =
    proxy.eventManager.register(plugin, T::class.java, order) {
        block(it)
    }

