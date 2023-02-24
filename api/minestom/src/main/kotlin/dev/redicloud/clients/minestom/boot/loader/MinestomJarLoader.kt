package dev.redicloud.clients.minestom.boot.loader

import dev.redicloud.libloader.boot.JarLoader
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader
import java.net.URL

class MinestomJarLoader(loader: Extension) : JarLoader {
    val loader: ExtensionClassLoader = loader::class.java.classLoader as ExtensionClassLoader

    override fun load(javaFile: URL?) {
        loader.addURL(javaFile!!)
    }
}