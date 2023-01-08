package net.dustrean.api.paper

import net.dustrean.api.Clients
import net.dustrean.api.paper.gui.PaperGuiProvider

class PaperClients() : Clients() {

    override val guiProvider = PaperGuiProvider()

}