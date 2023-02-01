package net.dustrean.clients.scoreboard

import net.kyori.adventure.text.Component
import java.util.*

interface Scoreboard {

    val title: (UUID) -> Component

    val lines: MutableMap<String, ScoreboardLine>

    fun addLine(line: ScoreboardLine)

    fun updateLine(name: String, line: ScoreboardLine)

    fun set(player: UUID)

    fun removeAll()

    fun remove(player: UUID)

    fun updateTitle(title: (UUID) -> Component)
}

inline fun Scoreboard.updateLine(name: String, crossinline init: ScoreboardLine.() -> Unit) {
    val line = lines[name] ?: return
    line.init()
    updateLine(name, line)
}