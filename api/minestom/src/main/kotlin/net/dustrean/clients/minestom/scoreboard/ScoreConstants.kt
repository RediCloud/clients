package net.dustrean.clients.minestom.scoreboard

import net.dustrean.clients.scoreboard.factories.ScoreboardFactory

object ScoreConstants {
    fun ScoreboardFactory.minestom(): MinestomScoreboard =
        MinestomScoreboard(title, lines)
}