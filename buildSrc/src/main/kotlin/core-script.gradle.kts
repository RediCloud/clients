repositories {
    maven("https://repo.redicloud.dev/releases")
    maven("https://repo.redicloud.dev/snapshots")
}
afterEvaluate {
    dependencies {
        add("implementation", "dev.redicloud.api:api:${BuildConstants.coreVersion}")
    }
}