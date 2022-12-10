plugins {
    `kotlin-script`
    `minestom-script`
    `core-script`
}
apply(plugin = "net.dustrean.libloader")

val shade by configurations

the(net.dustrean.libloader.plugin.LibraryLoader.LibraryLoaderConfig::class).apply {
    this.mainClass.set("net.dustrean.api.minestom.MinestomMainKt")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

dependencies {
    shade(project(":api:shared"))
}