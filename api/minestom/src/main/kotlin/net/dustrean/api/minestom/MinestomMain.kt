package net.dustrean.api.minestom

import net.dustrean.api.minestom.utils.env
import net.minestom.server.extras.MojangAuth

fun main() {
    server
    MojangAuth.init()

    server.start("0.0.0.0", env("service.bind.port").toInt())
}