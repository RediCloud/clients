package dev.redicloud.clients.minestom.boot.loader

import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader
import java.net.URL

class MinestomJarLoader(loader: Extension) : dev.redicloud.libloader.boot.JarLoader {
    val loader: ExtensionClassLoader = loader::class.java.classLoader as ExtensionClassLoader

    override fun load(javaFile: URL?) {
        loader.addURL(javaFile!!)
    }
}