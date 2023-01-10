package net.dustrean.clients.paper.gui

import net.dustrean.clients.gui.Gui
import net.dustrean.clients.gui.GuiProvider
import net.dustrean.clients.gui.inventory.AbstractInventory
import java.util.*

class PaperGuiProvider : GuiProvider() {

    override fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory {
        return PaperInventory(uniqueId, gui)
    }

}