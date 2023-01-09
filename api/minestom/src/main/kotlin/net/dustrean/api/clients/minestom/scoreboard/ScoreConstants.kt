package net.dustrean.api.clients.minestom.scoreboard

import net.dustrean.api.clients.scoreboard.factories.ScoreboardFactory

object ScoreConstants {
    fun ScoreboardFactory.minestom(): MinestomScoreboard =
        MinestomScoreboard(title, lines)
}