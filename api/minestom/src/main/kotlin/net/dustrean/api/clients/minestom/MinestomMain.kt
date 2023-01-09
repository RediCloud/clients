package net.dustrean.api.clients.minestom

import net.dustrean.api.clients.minestom.item.ItemEvents
import net.dustrean.api.clients.utils.env
import net.minestom.server.extras.MojangAuth
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy

fun main() {
    server
    MojangAuth.init()

    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    MinestomClients()
    server.start(System.getProperty("service.bind.host"), System.getProperty("service.bind.port").toInt())
}