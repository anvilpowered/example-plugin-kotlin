package org.example

import com.google.inject.Inject
import com.velocitypowered.api.command.BrigadierCommand
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import org.anvilpowered.kbrig.brigadier.toBrigadier
import org.example.command.PingCommand
import org.slf4j.Logger

@Plugin(
    id = "example-velocity-plugin",
    name = "Example Velocity Plugin",
    version = "0.1.0-SNAPSHOT",
    description = "An example Velocity plugin.",
    authors = ["Example Author"],
)
class ExampleVelocityPlugin @Inject constructor(
    private val proxyServer: ProxyServer,
    private val logger: Logger,
) {
    @Subscribe
    fun onProxyInit(event: ProxyInitializeEvent) {
        logger.info("Example Velocity Plugin is starting!")

        val commandNode = PingCommand.create().mapSource().toBrigadier()
        proxyServer.commandManager.register(BrigadierCommand(commandNode))

        logger.info("Example Velocity Plugin is ready!")
    }
}
