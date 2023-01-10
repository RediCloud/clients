package net.dustrean.clients.gui

import net.dustrean.clients.gui.inventory.AbstractInventory
import java.util.*

abstract class GuiProvider {

    abstract fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory

}