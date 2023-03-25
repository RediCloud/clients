plugins {
    `kotlin-script`
    `minestom-script`
    `core-script`
}
apply(plugin = "dev.redicloud.libloader")
apply(plugin = "maven-publish")

version = "1.0.0-SNAPSHOT"
group = "dev.redicloud.minestom.application"

val shade by configurations

the(dev.redicloud.libloader.plugin.LibraryLoader.LibraryLoaderConfig::class).apply {
    this.mainClass.set("dev.redicloud.minestom.application.MinestomMainKt")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    archiveFileName.set("application.jar")
}