repositories {
    maven {
        url = uri(
            "https://repo.dustrean.net/${
                if (BuildConstants.coreVersion.endsWith("-SNAPSHOT")) "snapshots" else "releases"
            }"
        )
        authentication.create<BasicAuthentication>("basic")
        credentials {
            username = (findProperty("DUSTREAN_REPO_USERNAME") as String?) ?: System.getenv("DUSTREAN_REPO_USERNAME")
            password = (findProperty("DUSTREAN_REPO_PASSWORD") as String?) ?: System.getenv("DUSTREAN_REPO_PASSWORD")
        }
    }
}
afterEvaluate {
    dependencies {
        add("implementation", "net.dustrean.api:api:${BuildConstants.coreVersion}")
    }
}
