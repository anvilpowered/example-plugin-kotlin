package org.example.command

import net.kyori.adventure.text.Component
import org.anvilpowered.kbrig.argument.BooleanArgumentType
import org.anvilpowered.kbrig.argument.IntegerArgumentType
import org.anvilpowered.kbrig.argument.StringArgumentType
import org.anvilpowered.kbrig.builder.LiteralArgumentBuilder
import org.anvilpowered.kbrig.builder.RequiredArgumentBuilder
import org.anvilpowered.kbrig.builder.executesSingleSuccess
import org.anvilpowered.kbrig.context.get
import org.anvilpowered.kbrig.tree.LiteralCommandNode
import org.example.PluginSource

object PingCommand {
    fun create(): LiteralCommandNode<PluginSource> {
        return LiteralArgumentBuilder<PluginSource>("ping")
            .executesSingleSuccess { it.source.sendMessage(Component.text("Pong!")) }
            .then(
                LiteralArgumentBuilder<PluginSource>("foo")
                    .executesSingleSuccess { context ->
                        context.source.sendMessage(Component.text("Bar!"))
                    },
            )
            .then(
                RequiredArgumentBuilder<PluginSource, _>("boolean", BooleanArgumentType)
                    .executesSingleSuccess { context ->
                        context.source.sendMessage(Component.text("Hello boolean ${context["boolean", Boolean::class]}"))
                    },
            )
            .then(
                RequiredArgumentBuilder<PluginSource, _>("integer", IntegerArgumentType(0, 10, setOf("0", "1", "5")))
                    .executesSingleSuccess { context ->
                        context.source.sendMessage(Component.text("Hello integer ${context["integer", Int::class]}"))
                    },
            )
            .then(
                RequiredArgumentBuilder<PluginSource, _>("greeting", StringArgumentType.QuotablePhrase)
                    .executesSingleSuccess { context ->
                        context.source.sendMessage(Component.text("Hello greeting ${context["greeting", String::class]}"))
                    },
            )
            .build()
    }
}
