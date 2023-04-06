plugins {
    id("dev.redicloud.libloader") version "1.6.3" apply false
    id("maven-publish")
}
allprojects {
    repositories {
        maven("https://repo.redicloud.dev/releases")
    }
    repositories {
        maven("https://repo.redicloud.dev/snapshots")
    }

    (tasks.findByName("jar") as Jar?)?.duplicatesStrategy = DuplicatesStrategy.WARN
}