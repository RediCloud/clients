package net.dustrean.clients.paper

import net.dustrean.clients.Clients
import net.dustrean.clients.paper.gui.PaperGuiProvider
import net.dustrean.clients.paper.gui.PaperInventoryEvents
import net.dustrean.clients.paper.item.ItemEvents

class PaperClients() : Clients() {

    init {
        INSTANCE = this
        ItemEvents()
        PaperInventoryEvents()
    }

    override val guiProvider = PaperGuiProvider()

}