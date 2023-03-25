package dev.redicloud.clients.minestom.lobby

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import dev.redicloud.api.ICoreAPI
import dev.redicloud.api.redis.codec.GsonCodec
import dev.redicloud.clients.minestom.lobby.model.ConfigModel
import dev.redicloud.libloader.boot.Bootstrap
import dev.redicloud.libloader.boot.apply.impl.JarResourceLoader
import dev.redicloud.minestom.application.createFallbackWorld
import dev.redicloud.minestom.application.loader.MinestomJarLoader
import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader

class LobbyExtension : Extension() {

    private lateinit var config: ConfigModel
    private lateinit var bootstrap: Bootstrap
    private lateinit var loader: ExtensionClassLoader
    private lateinit var resourceClassLoader: JarResourceLoader
    override fun preInitialize() {
        resourceClassLoader = JarResourceLoader("lobby", origin.originalJar)
        bootstrap = Bootstrap()
        bootstrap.apply(MinestomJarLoader(this).also {
            loader = it.loader
        }, loader, resourceClassLoader)
    }

    override fun initialize() {
        (ICoreAPI.INSTANCE.redisConnection.getRedissonClient().config.codec as GsonCodec).classLoaders.add(loader)
        GlobalScope.launch {
            config = ICoreAPI.INSTANCE.configManager.getConfigOrPut("lobby", ConfigModel::class.java) {
                ConfigModel()
            }
        }

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