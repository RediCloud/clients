package dev.redicloud.clients.velocity

import dev.redicloud.clients.Clients
import dev.redicloud.clients.gui.GuiProvider
import dev.redicloud.clients.velocity.gui.VelocityGuiProvider

class VelocityClients() : Clients() {

    init {
        INSTANCE = this
    }

    override val guiProvider: GuiProvider = VelocityGuiProvider()

}