rootProject.name = "clients"

include(":api:shared")
include(":api:minestom")
include(":api:paper")
include(":api:velocity")
include(":service-impl:minestom:lobby")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.redicloud.dev/releases")
    }
}