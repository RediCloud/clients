package net.dustrean.clients

import net.dustrean.clients.gui.GuiProvider
import net.dustrean.api.ICoreAPI

abstract class Clients {

    companion object {
        lateinit var INSTANCE: Clients
    }

    val core = ICoreAPI.INSTANCE
    abstract val guiProvider: GuiProvider

}