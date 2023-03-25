package dev.redicloud.clients.velocity.bootstrap

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Dependency
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import dev.redicloud.clients.velocity.VelocityClients
import dev.redicloud.libloader.boot.Bootstrap
import dev.redicloud.libloader.boot.loaders.URLClassLoaderJarLoader
import java.io.IOException
import java.net.URISyntaxException
import java.net.URLClassLoader

@Plugin(
    id = "velocity-clients",
    name = "velocity-clients",
    version = "1.0.0-SNAPSHOT",
    authors = ["RediCloud-Team"],
    dependencies = [Dependency(id = "core")]
)
class VelocityBootstrap @Inject constructor(private var proxyServer: ProxyServer) {

    init {
        Bootstrap().apply(URLClassLoaderJarLoader(this.javaClass.classLoader as URLClassLoader))
    }

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        VelocityClients()
    }

}