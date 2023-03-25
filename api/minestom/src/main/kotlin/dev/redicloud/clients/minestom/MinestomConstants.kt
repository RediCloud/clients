package dev.redicloud.clients.minestom

import dev.redicloud.minestom.application.extensionManager
import net.minestom.server.extensions.ExtensionClassLoader

fun ExtensionClassLoader.addCoreClassloader() {
    val core = extensionManager.getExtension("core")!!
    val coreClassloader =
        core::class.java.superclass.classLoader as ExtensionClassLoader
    coreClassloader.addChild(this)
}