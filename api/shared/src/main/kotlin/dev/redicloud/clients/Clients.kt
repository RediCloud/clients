package dev.redicloud.clients

import dev.redicloud.clients.gui.GuiProvider
import dev.redicloud.api.ICoreAPI

abstract class Clients {

    companion object {
        lateinit var INSTANCE: Clients
    }

    val core = ICoreAPI.INSTANCE
    abstract val guiProvider: GuiProvider

}