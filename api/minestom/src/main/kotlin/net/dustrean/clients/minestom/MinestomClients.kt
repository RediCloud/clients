package net.dustrean.clients.minestom

import net.dustrean.clients.Clients
import net.dustrean.clients.minestom.item.ItemEvents

class MinestomClients : Clients() {

    init {
        ItemEvents()
    }

    override val guiProvider = null!!

}