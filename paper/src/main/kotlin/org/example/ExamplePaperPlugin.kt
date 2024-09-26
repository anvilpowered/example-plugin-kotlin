package org.example

import io.papermc.paper.command.brigadier.CommandBuilder
import org.anvilpowered.kbrig.brigadier.toBrigadier
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.example.command.PingCommand

class ExamplePaperPlugin : JavaPlugin(), Listener {
    @Suppress("UnstableApiUsage")
    override fun onEnable() {
        CommandBuilder.of(this, "example")
            .then(PingCommand.create().mapSource().toBrigadier())
            .register()
    }
}
