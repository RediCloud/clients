package net.dustrean.clients.minestom.command

import net.dustrean.api.ICoreAPI
import net.dustrean.api.command.ICommand
import net.dustrean.api.command.data.CommandData
import net.minestom.server.command.builder.ArgumentCallback
import net.minestom.server.command.builder.arguments.Argument
import net.minestom.server.entity.Player
import net.minestom.server.command.builder.Command as MinestomCommand

class MinestomCommand(
    override val commandName: String,
    override val commandAliases: Array<String>,
    override val commandDescription: String,
    override val commandPermission: String
) : MinestomCommand(commandName, *commandAliases), ICommand {

    init {
        setDefaultExecutor { sender, context ->
            sender !is Player && return@setDefaultExecutor

            ICoreAPI.INSTANCE.commandManager.handleCommand(
                MinestomCommandActor(sender as Player),
                this,
                context.input.split(" ")
            )
        }
    }

    override val commands = arrayListOf<CommandData>()
}