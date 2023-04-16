package org.example

import com.google.inject.Inject
import org.apache.logging.log4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.lifecycle.LoadedGameEvent

class ExampleSpongePlugin @Inject constructor(
    private val logger: Logger,
) {

    @Listener
    fun onInit(event: LoadedGameEvent) {
        logger.info("Loading example plugin...")
    }

//    @Listener
//    fun registerCommands(event: RegisterCommandEvent<LiteralArgumentBuilder<*>>) {
//    }
}
