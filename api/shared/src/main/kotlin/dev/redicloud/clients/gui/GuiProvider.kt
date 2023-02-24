package dev.redicloud.clients.gui

import dev.redicloud.clients.gui.inventory.AbstractInventory
import java.util.*

abstract class GuiProvider {

    abstract fun createInventory(uniqueId: UUID, gui: Gui): AbstractInventory

}