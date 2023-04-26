package dev.redicloud.clients.minestom.utils

import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.ExtensionClassLoader

    fun printEntry(classLoader: ClassLoader?, visitedLoaders: MutableSet<ClassLoader> = mutableSetOf(), indent: String = "") {
        if (classLoader == null) {
            return
        }
        if (visitedLoaders.contains(classLoader)) {
            MinecraftServer.LOGGER.warn("${indent}WARNING: Circular reference detected for ClassLoader ${classLoader.name}")
            return
        }
        visitedLoaders.add(classLoader)
        MinecraftServer.LOGGER.info("${indent}ClassLoader: ${classLoader.name}")
        if (classLoader.parent != null) {
            MinecraftServer.LOGGER.info("${indent}\tParent: ${classLoader.parent.name}")
        }
        if (classLoader is ExtensionClassLoader) {
            val childrenField = ExtensionClassLoader::class.java.getDeclaredField("children")
            childrenField.isAccessible = true
            val children = childrenField.get(classLoader) as List<ExtensionClassLoader>
            if (children.isNotEmpty()) {
                MinecraftServer.LOGGER.info("${indent}\tChild ClassLoaders:")
                children.sortedBy { it.name }.forEach { child ->
                    printEntry(child, visitedLoaders, "$indent\t\t")
                }
            }
        }
    }