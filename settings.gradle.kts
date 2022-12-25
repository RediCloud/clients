rootProject.name = "clients"

include(":api:shared")
include(":api:minestom")
include(":api:paper")
include(":api:velocity")
include(":service-impl:minestom:lobby")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://repo.dustrean.net/releases")
            authentication.create<BasicAuthentication>("basic")
            credentials {
                val DUSTREAN_REPO_USERNAME: String? by settings
                val DUSTREAN_REPO_PASSWORD: String? by settings
                username = DUSTREAN_REPO_USERNAME ?: System.getenv("DUSTREAN_REPO_USERNAME")
                password = DUSTREAN_REPO_PASSWORD ?: System.getenv("DUSTREAN_REPO_PASSWORD")
            }
        }
    }
}