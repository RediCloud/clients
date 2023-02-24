package dev.redicloud.clients.paper.gui

import dev.redicloud.clients.gui.Gui
import dev.redicloud.clients.gui.GuiProvider
import dev.redicloud.clients.gui.inventory.AbstractInventory
import java.util.*

class PaperGuiProvider : GuiProvider() {

    override fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory {
        return PaperInventory(uniqueId, gui)
    }

}