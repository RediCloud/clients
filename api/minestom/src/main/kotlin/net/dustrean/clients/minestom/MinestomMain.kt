package net.dustrean.clients.minestom

import net.dustrean.clients.utils.env
import net.minestom.server.extras.MojangAuth
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy

fun main() {
    server //to init the val
    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    server.start(System.getProperty("service.bind.host"), System.getProperty("service.bind.port").toInt())
    net.dustrean.clients.minestom.MinestomClients()
}