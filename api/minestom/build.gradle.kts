plugins {
    `kotlin-script`
    `minestom-script`
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