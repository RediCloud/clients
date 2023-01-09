package net.dustrean.api.clients.paper

import net.dustrean.api.clients.Clients
import net.dustrean.api.clients.paper.gui.PaperGuiProvider
import net.dustrean.api.clients.paper.gui.PaperInventoryEvents
import net.dustrean.api.clients.paper.item.ItemEvents

class PaperClients() : net.dustrean.api.clients.Clients() {

    init {
        INSTANCE = this
        ItemEvents()
        PaperInventoryEvents()
    }

    override val guiProvider = PaperGuiProvider()

}