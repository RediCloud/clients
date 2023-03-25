package dev.redicloud.clients.velocity

import dev.redicloud.clients.Clients

class VelocityClients() : Clients() {

    init {
        INSTANCE = this
    }

    override val guiProvider = null!!

}