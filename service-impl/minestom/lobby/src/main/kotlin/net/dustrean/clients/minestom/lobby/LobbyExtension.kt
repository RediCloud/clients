package net.dustrean.clients.minestom.lobby

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dustrean.api.ICoreAPI
import net.dustrean.api.redis.codec.GsonCodec
import net.dustrean.clients.minestom.boot.loader.MinestomJarLoader
import net.dustrean.clients.minestom.createFallbackWorld
import net.dustrean.clients.minestom.lobby.model.ConfigModel
import net.dustrean.libloader.boot.Bootstrap
import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension
import net.minestom.server.extensions.ExtensionClassLoader

class LobbyExtension : Extension() {

    private lateinit var config: ConfigModel
    private lateinit var bootstrap: Bootstrap
    private lateinit var loader: ExtensionClassLoader
    override fun preInitialize() {
        println(this::class.java.classLoader::class.java.name)
        bootstrap = Bootstrap()
        bootstrap.apply(MinestomJarLoader(this).also { loader = it.loader }, loader, loader)

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