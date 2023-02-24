plugins {
    `kotlin-script`
    `velocity-script`
    `core-script`
}
apply(plugin = "maven-publish")

version = "1.0.0-SNAPSHOT"
group = "dev.redicloud.clients"

repositories {
    mavenCentral()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.WARN
    archiveFileName.set("${project.name}.jar")
}

dependencies {
    implementation(project(":api:shared"))
    compileOnly("net.kyori:adventure-api:${BuildConstants.adventureVersion}")
    compileOnly("net.kyori:adventure-text-minimessage:${BuildConstants.adventureVersion}")
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
                        findProperty("REDI_CLOUD_REPO_PASSWORD") as String?
                            ?: System.getenv("REDI_CLOUD_REPO_PASSWORD")
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