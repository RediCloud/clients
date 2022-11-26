package net.dustrean.api.minestom

import net.dustrean.api.minestom.commands.command
import net.minestom.server.command.builder.arguments.ArgumentLiteral
import net.minestom.server.command.builder.arguments.number.ArgumentInteger
import net.minestom.server.entity.Player

val testCommand = command(listOf("test")) {
    default {
        sender.sendMessage("cool")
    }

    syntax(ArgumentInteger("test-int")) {
        sender.sendMessage("just a single ${context.get<Int>("test-int")} argument")
    }

    syntax(listOf(ArgumentLiteral("literal1"), ArgumentLiteral("literal2"))) {
        sender.sendMessage("einfach zwei literals")
    }
}

val flyCommand = command(listOf("fly")) {
    default {
        if (sender !is Player) return@default
        val player = sender as Player
        player.isAllowFlying = !player.isAllowFlying
        if (!player.isAllowFlying) player.isFlying = false
    }
}