plugins {
    `kotlin-script`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    implementation("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
}