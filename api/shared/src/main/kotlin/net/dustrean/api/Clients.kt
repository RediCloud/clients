package net.dustrean.api

import net.dustrean.api.gui.GuiProvider

abstract class Clients {

    companion object {
        lateinit var INSTANCE: Clients
    }

    val core = ICoreAPI.INSTANCE
    abstract val guiProvider: GuiProvider

}