package dev.redicloud.clients.minestom.gui

import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiProvider
import dev.redicloud.clients.gui.inventory.AbstractInventory
import net.minestom.server.tag.Tag
import java.util.*

class MinestomGuiProvider : GuiProvider() {

    companion object {
        val TAG = Tag.String("gui_api")
        val GUIS = mutableMapOf<UUID, Gui>()
    }


    override fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory {
        GUIS[gui.identifier] = gui
        return MinestomInventory(uniqueId, gui)
    }

}