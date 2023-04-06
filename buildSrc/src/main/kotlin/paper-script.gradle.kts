plugins {
    kotlin("jvm")
    id("net.minecrell.plugin-yml.bukkit")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${BuildConstants.minecraftVersion}-R0.1-SNAPSHOT")
    library(kotlin("stdlib"))

    compileOnly("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    compileOnly("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
}
