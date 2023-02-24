package dev.redicloud.clients.minestom.scoreboard

import dev.redicloud.clients.scoreboard.factories.ScoreboardFactory

object ScoreConstants {
    fun ScoreboardFactory.minestom(): MinestomScoreboard =
        MinestomScoreboard(title, lines)
}