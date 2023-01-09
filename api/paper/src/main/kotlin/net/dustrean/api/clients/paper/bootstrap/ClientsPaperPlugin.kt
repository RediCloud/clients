package net.dustrean.api.clients.paper.bootstrap

import net.dustrean.api.clients.paper.PaperClients
import org.bukkit.plugin.java.JavaPlugin

class ClientsPaperPlugin : JavaPlugin() {

    override fun onLoad() {
        PaperClients()
    }

}