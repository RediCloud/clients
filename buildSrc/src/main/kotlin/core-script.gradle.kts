repositories {
    maven("https://repo.redicloud.dev/releases")
    maven("https://repo.redicloud.dev/snapshots")
}
afterEvaluate {
    dependencies {
        add("compileOnly", "dev.redicloud.api:api:${BuildConstants.coreVersion}")
    }
}