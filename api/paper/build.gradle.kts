plugins {
    `kotlin-script`
    `core-script`
    id("net.dustrean.libloader")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:${BuildConstants.minecraftVersion}-R0.1-SNAPSHOT")
    shade(project(":api:shared"))
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.WARN
}