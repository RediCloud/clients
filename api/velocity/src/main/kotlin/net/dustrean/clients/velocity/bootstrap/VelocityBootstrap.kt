package net.dustrean.clients.velocity.bootstrap

import com.velocitypowered.api.plugin.Plugin
import net.dustrean.clients.velocity.VelocityClients

@Plugin(
    id = "velocity-clients",
    name = "velocity-clients",
    version = "1.0.0-SNAPSHOT",
    authors = ["Dustrean-Team"],
)
class VelocityBootstrap {

    init {
        VelocityClients()
    }

}