rootProject.name = "clients"

include(":api:minestom")
include(":api:shared")
include(":api:velocity")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://repo.dustrean.net/releases")
        }
    }
}