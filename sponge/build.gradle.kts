import org.spongepowered.gradle.plugin.config.PluginLoaders

plugins {
    alias(libs.plugins.sponge)
}

sponge {
    apiVersion("8.1.0-SNAPSHOT")
    license("AGPL-3.0")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("example-plugin") {
        displayName("Example Plugin")
        version.set(project.version.toString())
        entrypoint("org.example.ExampleSpongePlugin")
        description("Agent plugin for the Anvil system")
    }
}

dependencies {
    compileOnly(libs.brigadier)
}
