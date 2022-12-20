plugins {
    `kotlin-script`
    `paper-script`
    id("net.dustrean.libloader")
}

dependencies {
    shade(project(":api:shared"))
}