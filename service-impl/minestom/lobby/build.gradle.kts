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

val shade by configurations

dependencies {
    shade("net.worldseed.multipart:WorldSeedEntityEngine:6.0.1") {
        exclude(group = "com.github.Minestom", module = "Minestom")
    }
    compileOnly(project(":api:minestom"))
    compileOnly(project(":api:shared"))
    compileOnly("org.redisson:redisson:3.18.0")
}
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    archiveFileName.set("${project.name}.jar")
}
