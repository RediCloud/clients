plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev")
    id("net.minecrell.plugin-yml.bukkit")
}

repositories {
    mavenCentral()
}

dependencies {
    paperDevBundle("${BuildConstants.minecraftVersion}-R0.1-SNAPSHOT")
    library(kotlin("stdlib"))

    implementation("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    implementation("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
}