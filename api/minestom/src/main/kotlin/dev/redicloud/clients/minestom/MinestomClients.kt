package dev.redicloud.clients.minestom

import dev.redicloud.clients.Clients
import dev.redicloud.clients.minestom.gui.MinestomGuiProvider
import dev.redicloud.clients.minestom.gui.MinestomInventoryEvents
import dev.redicloud.clients.minestom.item.ItemEvents

class MinestomClients : Clients() {

    init {
        ItemEvents()
        MinestomInventoryEvents()
    }

    override val guiProvider = MinestomGuiProvider()

}