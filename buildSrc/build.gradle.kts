plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    fun pluginDep(id: String, version: String) = "${id}:${id}.gradle.plugin:${version}"
    val kotlinVersion = "1.7.21"

    compileOnly(kotlin("gradle-plugin", embeddedKotlinVersion))
    runtimeOnly(kotlin("gradle-plugin", kotlinVersion))

    // Paper implementation
    implementation(pluginDep("io.papermc.paperweight.userdev", "1.3.11"))
    implementation(pluginDep("net.minecrell.plugin-yml.bukkit", "0.5.2"))
}