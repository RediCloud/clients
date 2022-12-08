plugins {
    `kotlin-script`
    `minestom-script`
}
apply(plugin = "net.dustrean.libloader")

the(net.dustrean.libloader.plugin.LibraryLoader.LibraryLoaderConfig::class).apply {
    this.mainClass.set("net.dustrean.api.minestom.MinestomMainKt")
}

dependencies {
    implementation(project(":api:shared"))
}