package net.dustrean.api.clients.paper.gui

import net.dustrean.api.clients.gui.Gui
import net.dustrean.api.clients.gui.GuiProvider
import java.util.*

class PaperGuiProvider : GuiProvider() {

    override fun createInventory(uniqueId: UUID, gui: Gui) = PaperInventory(uniqueId, gui)

}