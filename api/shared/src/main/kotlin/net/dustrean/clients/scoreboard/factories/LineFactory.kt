package net.dustrean.clients.scoreboard.factories

import net.dustrean.clients.scoreboard.ScoreboardLine
import net.kyori.adventure.text.Component
import java.util.*

class LineFactory {
    var name: String = ""
    var content: Component = Component.empty()
    var score: Int = 1
    var proceed: ((ScoreboardLine.(UUID) -> Unit))? = null

    fun proceed(block: (ScoreboardLine.(UUID) -> Unit)) {
        proceed = block
    }

    fun create(): ScoreboardLine =
        ScoreboardLineImpl(name, content, score, proceed)

    class ScoreboardLineImpl(
        override var name: String,
        override var content: Component,
        override var score: Int,
        override var proceed: (ScoreboardLine.(UUID) -> Unit)?
    ) : ScoreboardLine {
        override fun clone(): ScoreboardLineImpl =
            ScoreboardLineImpl(name, content, score, proceed)
    }
}