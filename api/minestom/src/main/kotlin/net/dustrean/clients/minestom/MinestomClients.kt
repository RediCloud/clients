package net.dustrean.clients.minestom

import net.dustrean.clients.Clients
import net.dustrean.clients.minestom.gui.MinestomGuiProvider
import net.dustrean.clients.minestom.gui.MinestomInventoryEvents
import net.dustrean.clients.minestom.item.ItemEvents
import java.util.*

class MinestomClients : Clients() {

    init {
        ItemEvents()
        MinestomInventoryEvents()
    }

    override val guiProvider = MinestomGuiProvider()

}