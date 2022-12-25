package net.dustrean.api.minestom.lobby

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable.invokeOnCompletion
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.dustrean.api.ICoreAPI
import net.dustrean.api.config.IConfigManager
import net.dustrean.api.item.enums.Material
import net.dustrean.api.item.factories.item
import net.dustrean.api.minestom.boot.loader.MinestomJarLoader
import net.dustrean.api.minestom.createFallbackWorld
import net.dustrean.api.minestom.getWorld
import net.dustrean.api.minestom.lobby.model.ConfigModel
import net.dustrean.api.minestom.lobby.model.animation.TestModel
import net.dustrean.api.minestom.lobby.register.EventRegister
import net.dustrean.libloader.boot.Bootstrap
import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader
import net.worldseed.multipart.ModelConfig
import net.worldseed.multipart.animations.AnimationHandlerImpl

class LobbyExtension : Extension() {

    companion object {
        val PLACEHOLDER = item(Material.BLACK_STAINED_GLASS_PANE) {
            name = Component.empty()
            blockAll = true
        }
    }
    private lateinit var config: ConfigModel

    override fun preInitialize() {
        println(this::class.java.classLoader::class.java.name)
        val loader: ExtensionClassLoader
        Bootstrap().apply(MinestomJarLoader(this).also { loader = it.loader }, loader, loader)
    }

    override fun initialize() {
        config = runCatching {
            runBlocking {
                ICoreAPI.INSTANCE.getConfigManager().getConfig<ConfigModel>("lobby")
            }
        }.getOrNull() ?: run {
            val config = ConfigModel()
            GlobalScope.launch { ICoreAPI.INSTANCE.getConfigManager().createConfig(config) }
            config
        }
        EventRegister.apply()

        MinecraftServer.getInstanceManager().createFallbackWorld()

        val model = TestModel()
        model.init(getWorld("fallback"), Pos(0.0, 2.0, 0.0, 0.0f, 0.0f), ModelConfig.defaultConfig)
        val animator = AnimationHandlerImpl(model)
        animator.playRepeat("idle")
    }

    override fun terminate() {

    }

}