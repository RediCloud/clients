package dev.redicloud.clients.minestom

import dev.redicloud.clients.utils.env
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy

fun main() {
    server //to init the val
    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    server.start(System.getProperty("service.bind.host"), System.getProperty("service.bind.port").toInt())
    MinestomClients()
}