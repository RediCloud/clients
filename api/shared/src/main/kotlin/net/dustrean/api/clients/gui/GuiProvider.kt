package net.dustrean.api.clients.gui

import net.dustrean.api.gui.inventory.AbstractInventory
import java.util.*

abstract class GuiProvider {

    abstract fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory

}