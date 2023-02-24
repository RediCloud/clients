package dev.redicloud.clients.scoreboard.factories

import dev.redicloud.clients.scoreboard.ScoreboardLine
import net.kyori.adventure.text.Component
import java.util.*

class ScoreboardFactory {
    val lines: MutableMap<String, ScoreboardLine> = mutableMapOf()
    var title: (UUID) -> Component = { Component.empty() }

    inline fun line(crossinline init: LineFactory.() -> Unit) {
        val line = LineFactory().apply(init).create()
        lines.putIfAbsent(line.name, line) ?: return
        throw IllegalArgumentException("Line name already exists")
    }

    fun empty(score: Int) =
        line {
            this.score = score
            this.name = "empty-$score"
            this.content = Component.empty()
        }

    inline fun dynamic(
        score: Int,
        name: String,
        crossinline init: ScoreboardLine.(UUID) -> Unit,
        startContent: Component = Component.empty()
    ) {
        line {
            this.score = score
            this.name = name
            this.content = startContent
            this.proceed = {
                this.init(it)
            }
        }
    }
}