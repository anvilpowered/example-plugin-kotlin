package org.example

import com.velocitypowered.api.command.CommandSource
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import org.anvilpowered.kbrig.tree.LiteralCommandNode
import org.anvilpowered.kbrig.tree.mapSource

class VelocityBridgeSource(private val velocityCommandSource: CommandSource) : PluginSource, ForwardingAudience.Single {
    override fun audience(): Audience = velocityCommandSource
}

fun LiteralCommandNode<PluginSource>.mapSource(): LiteralCommandNode<CommandSource> = mapSource { VelocityBridgeSource(it) }
