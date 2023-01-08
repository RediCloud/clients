package net.dustrean.api.paper.gui

import net.dustrean.api.gui.Gui
import net.dustrean.api.gui.GuiProvider
import java.util.*

class PaperGuiProvider : GuiProvider() {

    override fun createInventory(uniqueId: UUID, gui: Gui) = PaperInventory(uniqueId, gui)

}