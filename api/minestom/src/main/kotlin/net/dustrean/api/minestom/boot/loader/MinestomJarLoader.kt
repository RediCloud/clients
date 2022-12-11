package net.dustrean.api.minestom.boot.loader

import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader
import java.net.URL

class MinestomJarLoader(loader: Extension): net.dustrean.libloader.boot.JarLoader {
    val loader: ExtensionClassLoader = loader::class.java.superclass.getDeclaredMethod(
        "getExtensionClassLoader"
    ).also { it.isAccessible = true }.invoke(loader) as ExtensionClassLoader

    override fun load(javaFile: URL?) {
        loader.addURL(javaFile!!)
    }
}