package dev.redicloud.minestom.application

import net.minestom.server.MinecraftServer
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy

fun main() {
    server //to init the val
    if (System.getenv("VELOCITY_SECRET") != null) {
        MinecraftServer.LOGGER.info("Using velocity proxy support!")
        VelocityProxy.enable(System.getenv("VELOCITY_SECRET"))
    } else {
        MinecraftServer.LOGGER.warn("Velocity secret not set, velocity support disabled!")
    }
    OptifineSupport.enable()
    if (System.getProperty("service.bind.host") == null || System.getProperty("service.bind.port") == null) {
        MinecraftServer.LOGGER.warn("Service bind host or port not set, using default values!")
    }
    val address = System.getProperty("service.bind.host") ?: "127.0.0.1"
    val port = (System.getProperty("service.bind.port") ?: "5000").toInt()
    MinecraftServer.LOGGER.info("Starting on $address:$port")
    server.start(
        address,
        port
    )
}