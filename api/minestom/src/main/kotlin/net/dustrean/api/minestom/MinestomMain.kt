package net.dustrean.api.minestom

import net.dustrean.api.minestom.skin.SkinProvider
import net.dustrean.api.minestom.utils.env

fun main() {
    SkinProvider.skinInit

    server.start("0.0.0.0", env("service.bind.port"))
}