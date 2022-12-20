plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev")
}

dependencies {
    paperDevBundle("${BuildConstants.minecraftVersion}-R0.1-SNAPSHOT")
}

tasks {
    assemble {
        dependsOn(named("reobfJar"))
    }
}