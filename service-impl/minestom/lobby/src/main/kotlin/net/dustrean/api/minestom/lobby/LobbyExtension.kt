package net.dustrean.api.minestom.lobby

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dustrean.api.ICoreAPI
import net.dustrean.api.item.enums.Material
import net.dustrean.api.item.factories.item
import net.dustrean.api.minestom.addCoreClassloader
import net.dustrean.api.minestom.boot.loader.MinestomJarLoader
import net.dustrean.api.minestom.createFallbackWorld
import net.dustrean.api.minestom.lobby.model.ConfigModel
import net.dustrean.api.minestom.lobby.register.EventRegister
import net.dustrean.api.redis.codec.GsonCodec
import net.dustrean.libloader.boot.Bootstrap
import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader

class LobbyExtension : Extension() {

    companion object {
        val PLACEHOLDER = item(Material.BLACK_STAINED_GLASS_PANE) {
            name = Component.empty()
            blockAll = true
        }
    }

    private lateinit var config: ConfigModel
    private lateinit var bootstrap: Bootstrap
    private lateinit var loader: ExtensionClassLoader
    override fun preInitialize() {
        println(this::class.java.classLoader::class.java.name)
        bootstrap = Bootstrap()
        bootstrap.apply(MinestomJarLoader(this).also { loader = it.loader }, loader, loader)

    }

    override fun initialize() {
        (ICoreAPI.INSTANCE.getRedisConnection().getRedissonClient()
            .config.codec as GsonCodec).classLoaders.add(loader)
        GlobalScope.launch {
            config = if (ICoreAPI.INSTANCE.getConfigManager().exists("lobby")) ICoreAPI.INSTANCE.getConfigManager()
                .getConfig("lobby") else ICoreAPI.INSTANCE.getConfigManager().createConfig(ConfigModel())
        }

        EventRegister.apply()

        MinecraftServer.getInstanceManager().createFallbackWorld()

        //val model = TestModel()
        //model.init(getWorld("fallback"), Pos(0.0, 2.0, 0.0, 0.0f, 0.0f), ModelConfig.defaultConfig)
        //val animator = AnimationHandlerImpl(model)
        //animator.playRepeat("idle")
        bootstrap.bootSuccess()
    }

    override fun terminate() {

    }

}