package net.dustrean.api.minestom.scoreboard

import net.dustrean.api.minestom.getPlayer
import net.dustrean.api.scoreboard.Scoreboard
import net.dustrean.api.scoreboard.ScoreboardLine
import net.kyori.adventure.text.Component
import java.util.*
import net.minestom.server.scoreboard.Sidebar as MinestomSidebar
import net.minestom.server.scoreboard.Sidebar.ScoreboardLine as MinestomLine

class MinestomScoreboard(
    override var title: (UUID) -> Component,
    override val lines: MutableMap<String, ScoreboardLine>
) : Scoreboard {
    var scoreboard: MutableMap<UUID, MinestomSidebar> = mutableMapOf()
    override fun addLine(line: ScoreboardLine) {
        lines.putIfAbsent(line.name, line) ?: return
        throw IllegalArgumentException("Line name already exists")
    }

    override fun updateLine(name: String, line: ScoreboardLine) {
        lines[name] = line
    }

    override fun set(player: UUID) {
        if (scoreboard.containsKey(player)) {
            scoreboard[player]?.viewers?.clear()
        }
        scoreboard[player] = MinestomSidebar(title(player)).apply {
            this@MinestomScoreboard.lines.forEach { (_, it) ->
                val newIt = if (it.proceed != null) {
                    it.clone().apply {
                        it.proceed!!(this, player)
                    }
                } else it

                createLine(
                    MinestomLine(
                        newIt.name,
                        newIt.content,
                        newIt.score
                    )
                )
            }
            addViewer(player.getPlayer() ?: return)
        }
    }

    override fun removeAll() {
        scoreboard.forEach {
            it.value.viewers.clear()
        }
        scoreboard.clear()
    }

    override fun remove(player: UUID) {
        scoreboard[player]?.viewers?.clear()
        scoreboard.remove(player)
    }

    override fun updateTitle(title: (UUID) -> Component) {
        this.title = title
    }
}