package net.dustrean.clients.minestom.lobby.register

import net.dustrean.clients.minestom.lobby.events.PlayerEvent

object EventRegister {
    private val events: List<Any> // return new list on each appliance
        get() = listOf(
            PlayerEvent()
        )

    fun apply() {
        events
    }
}