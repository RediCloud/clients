package dev.redicloud.clients.paper.bootstrap

import dev.redicloud.clients.paper.PaperClients
import org.bukkit.plugin.java.JavaPlugin

class ClientsPaperPlugin : JavaPlugin() {

    override fun onLoad() {
        PaperClients()
    }

}