package net.dustrean.api.gui

import net.dustrean.api.gui.inventory.AbstractInventory
import java.util.*

abstract class GuiProvider {

    abstract fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory

}