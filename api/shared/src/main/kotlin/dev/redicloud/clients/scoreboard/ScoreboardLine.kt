package dev.redicloud.clients.scoreboard

import net.kyori.adventure.text.Component
import java.util.*

interface ScoreboardLine {
    var name: String

    var content: Component

    var score: Int

    var proceed: (ScoreboardLine.(UUID) -> Unit)?

    fun clone(): ScoreboardLine
}