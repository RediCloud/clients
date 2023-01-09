plugins {
    `kotlin-script`
    `velocity-script`
    `core-script`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api:shared"))
}