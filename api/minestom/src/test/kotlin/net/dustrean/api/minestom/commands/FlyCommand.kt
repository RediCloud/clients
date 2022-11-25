package net.dustrean.api.minestom.commands

import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player

class FlyCommand : Command("fly") {
    init {
        setDefaultExecutor { sender, context ->
            if (sender !is Player) return@setDefaultExecutor
            val player = sender as Player
            player.isAllowFlying = !player.isAllowFlying
            if (!player.isAllowFlying) player.isFlying = false
        }
    }
}