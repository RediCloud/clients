package net.dustrean.api.clients.minestom.lobby.register

import net.dustrean.api.clients.minestom.lobby.events.PlayerEvent

object EventRegister {
    private val events: List<Any> // return new list on each appliance
        get() = listOf(
            PlayerEvent()
        )

    fun apply() {
        events
    }
}