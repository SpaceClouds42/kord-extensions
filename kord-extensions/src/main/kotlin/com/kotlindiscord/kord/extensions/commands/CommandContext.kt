package com.kotlindiscord.kord.extensions.commands

import com.gitlab.kordlib.core.event.message.MessageCreateEvent

/**
 * Light wrapper class representing the context for a command's action.
 *
 * This is what `this` refers to in a command action body. You shouldn't have to
 * instantiate this yourself.
 *
 * @param command Respective command for this context object.
 * @param event Event that triggered this command.
 * @param args Array of string arguments for this command.
 */
class CommandContext(
    val command: Command,
    val event: MessageCreateEvent,
    val args: Array<String>
) {
    /**
     * Attempt to parse the arguments in this CommandContext into a given data class.
     *
     * TODO: Exceptions, etc
     *
     * @param T Data class to parse arguments into.
     */
    suspend inline fun <reified T : Any> parse(): T? = command.parser.parse(T::class, args, event)
}
