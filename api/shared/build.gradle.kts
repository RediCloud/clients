plugins {
    `kotlin-script`
    `core-script`
}
apply(plugin = "dev.redicloud.libloader")
apply(plugin = "maven-publish")

version = "1.0.0-SNAPSHOT"
group = "dev.redicloud.clients"

val lib: Configuration by configurations.creating
configurations.compileClasspath.get().extendsFrom(lib)

the(dev.redicloud.libloader.plugin.LibraryLoader.LibraryLoaderConfig::class).apply {
    configurationName.set("lib")
    doBootstrapShade.set(false)
}

repositories {
    mavenCentral()
}

dependencies {
    lib("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    lib("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
}

afterEvaluate {
    (extensions["publishing"] as PublishingExtension).apply {
        repositories {
            maven {
                name = "redicloud"
                url = uri(
                    if (!project.version.toString()
                            .endsWith("-SNAPSHOT")
                    ) "https://repo.redicloud.dev/releases" else "https://repo.redicloud.dev/snapshots"
                )
                credentials {
                    username =
                        findProperty("REDI_CLOUD_REPO_USERNAME") as String?
                            ?: System.getenv("REDI_CLOUD_REPO_USERNAME")
                    password =
                        findProperty("REDI_CLOUD_REPO_USERNAME") as String?
                            ?: System.getenv("REDI_CLOUD_REPO_USERNAME")
                }
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
        }
        publications {
            create<MavenPublication>(project.name.replace("-", "_")) {
                groupId = project.group.toString()
                artifactId = project.name
                version = "${project.version}"
                from(components["java"])
            }
        }
    }
}