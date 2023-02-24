package dev.redicloud.clients.minestom.lobby.model

import dev.redicloud.api.config.IConfig

data class ConfigModel(
    val placeholder: String = "placeholder"
) : IConfig {
    override val key: String = "lobby"
}