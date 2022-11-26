package net.dustrean.api.minestom.commands

import net.dustrean.api.minestom.commandManager
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.arguments.Argument
import net.minestom.server.command.builder.condition.CommandCondition
import net.minestom.server.command.builder.exception.ArgumentSyntaxException

inline fun command(names: List<String>, crossinline builder: CommandBuilder.() -> Unit): Command =
    CommandBuilder(names).apply(builder).also {
        commandManager.register(it)
    }

class CommandBuilder(names: List<String>) : Command(names.first(), *arrayListOf(names).removeFirst().toTypedArray()) {

    inline fun default(crossinline runs: (sender: CommandSender, context: CommandContext) -> Unit) =
        setDefaultExecutor { sender, context -> runs(sender, context) }

    inline fun arguments(
        argument: Argument<*>,
        crossinline exception: (sender: CommandSender, exception: ArgumentSyntaxException) -> Unit
    ) = setArgumentCallback({ sender, argumentException -> exception(sender, argumentException) }, argument)

    inline fun syntax(
        arguments: List<Argument<*>>, crossinline syntax: (sender: CommandSender, context: CommandContext) -> Unit
    ) {
        addSyntax({ sender, context -> syntax(sender, context) }, *arguments.toTypedArray())
    }

    inline fun conditionalSyntax(
        arguments: List<Argument<*>>,
        crossinline condition: (sender: CommandSender, commandString: String?) -> Boolean,
        crossinline syntax: (sender: CommandSender, context: CommandContext) -> Unit
    ) {
        addConditionalSyntax(
            { sender, string -> condition(sender, string) },
            { sender, context -> syntax(sender, context) },
            *arguments.toTypedArray()
        )
    }

    inline fun subCommand(names: List<String>, crossinline builder: CommandBuilder.() -> Unit) =
        addSubcommand(CommandBuilder(names).apply(builder))

    fun condition(condition: CommandCondition) = setCondition(condition)
}