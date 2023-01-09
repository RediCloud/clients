package net.dustrean.api.clients

import net.dustrean.api.gui.GuiProvider

abstract class Clients {

    companion object {
        lateinit var INSTANCE: net.dustrean.api.clients.Clients
    }

    val core = net.dustrean.api.ICoreAPI.Companion.INSTANCE
    abstract val guiProvider: GuiProvider

}