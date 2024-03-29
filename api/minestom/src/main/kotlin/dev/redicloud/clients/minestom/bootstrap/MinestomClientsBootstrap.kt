package dev.redicloud.clients.minestom.bootstrap

import dev.redicloud.clients.minestom.MinestomClients
import dev.redicloud.libloader.boot.Bootstrap
import dev.redicloud.libloader.boot.apply.impl.JarResourceLoader
import dev.redicloud.minestom.application.addExtensionClassLoader
import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader

class MinestomClientsBootstrap : Extension() {

    lateinit var classLoader: ExtensionClassLoader

    override fun preInitialize() {
        classLoader = this.javaClass.classLoader as ExtensionClassLoader
        Bootstrap().apply({
            classLoader.addURL(it)
        }, classLoader, JarResourceLoader("clients-minestom", origin.originalJar))
    }

    override fun initialize() {
        MinestomClients()
    }

    override fun terminate() {

    }
}