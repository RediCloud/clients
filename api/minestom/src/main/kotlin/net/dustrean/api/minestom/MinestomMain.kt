package net.dustrean.api.minestom

import net.dustrean.api.minestom.item.ItemEvents
import net.dustrean.api.minestom.utils.env
import net.minestom.server.extras.MojangAuth
import net.minestom.server.extras.optifine.OptifineSupport
import net.minestom.server.extras.velocity.VelocityProxy

fun main() {
    server
    MojangAuth.init()

    VelocityProxy.enable(env("VELOCITY_SECRET"))
    OptifineSupport.enable()
    ItemEvents()
    server.start("0.0.0.0", env("service.bind.port").toInt())
}