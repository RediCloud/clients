package net.dustrean.api.minestom.utils

import net.dustrean.api.minestom.component.component

inline fun <reified T> env(name: String): T = System.getenv(name) as T

fun test() {
    component("test") {
        component("sadaw")

        onClickCopy("sadawd")
    }
}