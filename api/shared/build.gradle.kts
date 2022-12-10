import net.dustrean.libloader.plugin.LibraryLoader

plugins {
    `kotlin-script`
    `core-script`
}
apply(plugin = "net.dustrean.libloader")

val lib: Configuration by configurations.creating
configurations.compileClasspath.get().extendsFrom(lib)

the(LibraryLoader.LibraryLoaderConfig::class).apply {
    configurationName.set("lib")
    doBootstrapShade.set(false)
}

repositories {
    mavenCentral()
}

dependencies {
    lib("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    lib("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
}