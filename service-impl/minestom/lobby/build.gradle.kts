plugins {
    `kotlin-script`
    `core-script`
    `minestom-script`
}
apply(plugin = "net.dustrean.libloader")
group = "net.dustrean.api.minestom"

repositories {
    maven("https://jitpack.io")
    maven("https://reposilite.worldseed.online/public")
}

dependencies {
    implementation("net.worldseed.multipart:WorldSeedEntityEngine:6.0.1")
    compileOnly(project(":api:minestom"))
    compileOnly(project(":api:shared"))
}
