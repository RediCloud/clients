package net.dustrean.clients.paper.command

import net.dustrean.api.command.ICommandActor
import org.bukkit.entity.Player

class PaperCommandActor(private val player: Player) : ICommandActor {

    override val uuid = player.uniqueId

    override fun hasPermission(permission: String) = player.hasPermission(permission)

    override fun sendMessage(message: String) = player.sendMessage(message)
}