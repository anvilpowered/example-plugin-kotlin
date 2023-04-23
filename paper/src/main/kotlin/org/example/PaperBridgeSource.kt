@file:Suppress("UnstableApiUsage")

package org.example

import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import org.anvilpowered.kbrig.tree.LiteralCommandNode
import org.anvilpowered.kbrig.tree.mapSource

class PaperBridgeSource(private val paperCommandSource: CommandSourceStack) : PluginSource, ForwardingAudience.Single {
    override fun audience(): Audience = paperCommandSource.bukkitSender
}

fun LiteralCommandNode<PluginSource>.mapSource(): LiteralCommandNode<CommandSourceStack> = mapSource { PaperBridgeSource(it) }
