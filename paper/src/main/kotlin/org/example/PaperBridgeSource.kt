package org.example

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import org.anvilpowered.kbrig.tree.LiteralCommandNode
import org.anvilpowered.kbrig.tree.mapSource
import org.bukkit.command.CommandSender

class PaperBridgeSource(private val paperCommandSource: CommandSender) : PluginSource, ForwardingAudience.Single {
    override fun audience(): Audience = paperCommandSource
}

fun LiteralCommandNode<PluginSource>.mapSource(): LiteralCommandNode<CommandSender> = mapSource { PaperBridgeSource(it) }
