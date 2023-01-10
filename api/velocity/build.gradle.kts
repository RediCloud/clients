plugins {
    `kotlin-script`
    `velocity-script`
    `core-script`
}
apply(plugin = "maven-publish")

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api:shared"))
}

afterEvaluate {
    (extensions["publishing"] as PublishingExtension).apply {
        repositories {
            maven {
                name = "dustrean"
                url = uri(
                    if (!project.version.toString()
                            .endsWith("-SNAPSHOT")
                    ) "https://repo.dustrean.net/releases" else "https://repo.dustrean.net/snapshots"
                )
                credentials {
                    username =
                        findProperty("DUSTREAN_REPO_USERNAME") as String?
                            ?: System.getenv("DUSTREAN_REPO_USERNAME")
                    password =
                        findProperty("DUSTREAN_REPO_PASSWORD") as String?
                            ?: System.getenv("DUSTREAN_REPO_PASSWORD")
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