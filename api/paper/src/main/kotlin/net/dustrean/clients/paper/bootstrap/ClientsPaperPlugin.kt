package net.dustrean.clients.paper.bootstrap

import net.dustrean.clients.paper.PaperClients
import org.bukkit.plugin.java.JavaPlugin

class ClientsPaperPlugin : JavaPlugin() {

    override fun onLoad() {
        PaperClients()
    }

}