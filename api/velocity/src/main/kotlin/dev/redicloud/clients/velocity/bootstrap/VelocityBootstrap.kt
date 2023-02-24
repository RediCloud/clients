package dev.redicloud.clients.velocity.bootstrap

import com.velocitypowered.api.plugin.Plugin
import dev.redicloud.clients.velocity.VelocityClients

@Plugin(
    id = "velocity-clients",
    name = "velocity-clients",
    version = "1.0.0-SNAPSHOT",
    authors = ["RediCloud-Team"],
)
class VelocityBootstrap {

    init {
        VelocityClients()
    }

}