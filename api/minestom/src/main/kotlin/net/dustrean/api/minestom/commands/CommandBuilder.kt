package net.dustrean.api.minestom.commands

import net.dustrean.api.minestom.commandManager
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.CommandContext
import net.minestom.server.command.builder.arguments.Argument
import net.minestom.server.command.builder.condition.CommandCondition
import net.minestom.server.command.builder.exception.ArgumentSyntaxException

/**
 * Function to create a Minestom command.
 * It uses the [CommandBuilder] to easily modify the command.
 * It will automatically be registered
 *
 * @param names the names of the command, containing the aliases (first entry is name)
 * @param builder the [CommandBuilder] block
 *
 * @return the built command
 */
inline fun command(names: List<String>, crossinline builder: CommandBuilder.() -> Unit): Command =
    CommandBuilder(names).apply(builder).also {
        commandManager.register(it)
    }


/**
 * The CommandBuilder to create Minestom commands.
 * Extends the Minestom [Command]
 * @param names the names of the command, containing the aliases (first entry is name)
 */
class CommandBuilder(names: List<String>) : Command(names.first(), *arrayListOf(names).removeFirst().toTypedArray()) {

    /**
     * Sets the default response without any arguments or on an error
     * @param runs the block to configure the callback
     */
    inline fun default(crossinline runs: CommandExecutor.() -> Unit) =
        setDefaultExecutor { sender, context -> runs(CommandExecutor(sender, context)) }

    /**
     * Builds the customized callback of an argument
     * @param argument the callback's argument
     * @param exception the exception builder of the argument
     */
    inline fun argumentCallbacks(
        argument: Argument<*>, crossinline exception: ArgumentCallback.() -> Unit
    ) = setArgumentCallback(
        { sender, argumentException -> exception(ArgumentCallback(sender, argumentException)) }, argument
    )

    /**
     * Builds the syntax for the given argument
     * @param argument the arguments of the syntax
     * @param syntax the syntax builder
     */
    inline fun syntax(
        argument: Argument<*>, crossinline syntax: CommandExecutor.() -> Unit
    ) {
        addSyntax({ sender, context -> syntax(CommandExecutor(sender, context)) }, argument)
    }


    /**
     * Builds the syntax for the arguments in the list
     * @param arguments the arguments of the syntax
     * @param syntax the syntax builder
     */
    inline fun syntax(
        arguments: List<Argument<*>>, crossinline syntax: CommandExecutor.() -> Unit
    ) {
        addSyntax({ sender, context -> syntax(CommandExecutor(sender, context)) }, *arguments.toTypedArray())
    }

    /**
     * Builds a conditional syntax for the arguments in the list
     * @param arguments the arguments of the syntax
     * @param condition the condition the sender has to reach
     * @param syntax the syntax builder
     */
    inline fun conditionalSyntax(
        arguments: List<Argument<*>>,
        crossinline condition: SyntaxCondition.() -> Boolean,
        crossinline syntax: CommandExecutor.() -> Unit
    ) {
        addConditionalSyntax(
            { sender, string -> condition(SyntaxCondition(sender, string)) },
            { sender, context -> syntax(CommandExecutor(sender, context)) },
            *arguments.toTypedArray()
        )
    }

    /**
     * Sets the condition of the command
     * @param condition the [CommandCondition]
     */
    fun condition(condition: CommandCondition) = setCondition(condition)

    /**
     * Build a subcommand. It uses [CommandBuilder]
     * @param names the names of the command, containing the aliases (first entry is name)
     * @param builder the [CommandBuilder] block
     */
    inline fun subCommand(names: List<String>, crossinline builder: CommandBuilder.() -> Unit) =
        addSubcommand(CommandBuilder(names).apply(builder))
}

class CommandExecutor(val sender: CommandSender, val context: CommandContext)
class ArgumentCallback(val sender: CommandSender, val exception: ArgumentSyntaxException)
class SyntaxCondition(val sender: CommandSender, val commandString: String?)