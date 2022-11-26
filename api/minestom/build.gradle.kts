plugins {
    `kotlin-script`
    `minestom-script`
}

dependencies {
    implementation(project(":api:shared"))
}

tasks {
    jar {
        manifest {
            attributes(
                mapOf(
                    "Main-Class" to "net.dustrean.api.minestom.MinestomMainKt", "Manifest-Version" to "1.0"
                )
            )
        }
    }
}