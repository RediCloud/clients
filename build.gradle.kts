plugins {
    id("net.dustrean.libloader") version "1.6.2" apply false
    id("maven-publish")
}
allprojects {
    repositories {
        maven {
            url = uri("https://repo.dustrean.net/releases")
            authentication.create<BasicAuthentication>("basic")
            credentials {
                username = (findProperty("DUSTREAN_REPO_USERNAME") as String?)
                    ?: System.getenv("DUSTREAN_REPO_USERNAME")
                password = (findProperty("DUSTREAN_REPO_PASSWORD") as String?)
                    ?: System.getenv("DUSTREAN_REPO_PASSWORD")
            }
        }
    }
    repositories {
        maven {
            url = uri("https://repo.dustrean.net/snapshots")
            authentication.create<BasicAuthentication>("basic")
            credentials {
                username = (findProperty("DUSTREAN_REPO_USERNAME") as String?)
                    ?: System.getenv("DUSTREAN_REPO_USERNAME")
                password = (findProperty("DUSTREAN_REPO_PASSWORD") as String?)
                    ?: System.getenv("DUSTREAN_REPO_PASSWORD")
            }
        }
    }


    (tasks.findByName("jar") as Jar?)?.duplicatesStrategy = DuplicatesStrategy.WARN
}