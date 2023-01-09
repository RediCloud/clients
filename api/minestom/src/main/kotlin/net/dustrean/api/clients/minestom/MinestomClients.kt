package net.dustrean.api.clients.minestom

import net.dustrean.api.clients.Clients
import net.dustrean.api.clients.minestom.item.ItemEvents

class MinestomClients : Clients() {

    init {
        ItemEvents()
    }

    override val guiProvider = null!!

}