package dev.redicloud.clients.paper

import dev.redicloud.clients.Clients
import dev.redicloud.clients.paper.gui.PaperGuiProvider
import dev.redicloud.clients.paper.gui.PaperInventoryEvents
import dev.redicloud.clients.paper.item.ItemEvents

class PaperClients() : Clients() {

    init {
        INSTANCE = this
        ItemEvents()
        PaperInventoryEvents()
    }

    override val guiProvider = PaperGuiProvider()

}