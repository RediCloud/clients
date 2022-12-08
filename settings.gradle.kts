rootProject.name = "clients"

include(":api:minestom")
include(":api:shared")
include(":api:velocity")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://repo.dustrean.net/releases")
            authentication.create<BasicAuthentication>("basic")
            credentials {
                username = System.getenv("DUSTREAN_REPO_USERNAME")
                password = System.getenv("DUSTREAN_REPO_PASSWORD")
            }
        }
    }
}