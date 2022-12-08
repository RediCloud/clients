plugins {
    id("net.dustrean.libloader") version "1.2.0" apply false
}
allprojects {
    afterEvaluate {
        if (plugins.hasPlugin("net.dustrean.libloader")) {
            repositories {
                maven {
                    url = uri("https://repo.dustrean.net/releases")
                    authentication.create<BasicAuthentication>("basic")
                    credentials {
                        username = (findProperty("DUSTREAN_REPO_USERNAME") as String?) ?: System.getenv("DUSTREAN_REPO_USERNAME")
                        password = (findProperty("DUSTREAN_REPO_PASSWORD") as String?) ?: System.getenv("DUSTREAN_REPO_PASSWORD")
                    }
                }
            }
        }
    }
}