package net.dustrean.clients

import net.dustrean.clients.gui.GuiProvider

abstract class Clients {

    companion object {
        lateinit var INSTANCE: Clients
    }

    val core = net.dustrean.api.ICoreAPI.Companion.INSTANCE
    abstract val guiProvider: GuiProvider

}