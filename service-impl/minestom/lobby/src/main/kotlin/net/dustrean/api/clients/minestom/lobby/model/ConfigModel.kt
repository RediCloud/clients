package net.dustrean.api.clients.minestom.lobby.model

import net.dustrean.api.config.IConfig

data class ConfigModel(
    val placeholder: String = "placeholder"
) : IConfig {
    override val key: String = "lobby"
}