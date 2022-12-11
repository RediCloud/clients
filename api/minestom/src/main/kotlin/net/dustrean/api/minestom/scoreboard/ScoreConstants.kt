package net.dustrean.api.minestom.scoreboard

import net.dustrean.api.minestom.scoreboard.factories.ScoreboardFactory

object ScoreConstants {
    fun ScoreboardFactory.minestom(): MinestomScoreboard =
        MinestomScoreboard(title, lines)
}