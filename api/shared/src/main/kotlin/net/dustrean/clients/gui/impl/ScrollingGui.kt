package net.dustrean.clients.gui.impl

import net.dustrean.clients.Clients
import net.dustrean.clients.gui.Gui
import net.dustrean.clients.gui.GuiType
import net.dustrean.clients.item.UnassignedItemStack
import net.dustrean.clients.item.enums.Material
import net.dustrean.api.language.component.inventory.InventoryComponentProvider
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import java.util.*

class ScrollingGui(
    val scrollType: ScrollType,
    rows: Int,
    languageProvider: (UUID) -> InventoryComponentProvider.() -> Unit,
) : Gui(
    GuiType.CHEST, rows, languageProvider
) {

    companion object {
        val PLACEHOLDER = UnassignedItemStack({ Material.PAPER }, {
            {
                key = "placeholder"
                name = Component.empty().color(NamedTextColor.GOLD)
            }
        }, { 1 }, { 0 }, { false }, { true }, { true }, { true })
        val SCROLL_DOWN = UnassignedItemStack({ Material.PAPER }, {
            {
                key = "scroll_down"
                name = Component.text("Scroll down").color(NamedTextColor.GOLD)
            }
        }, { 1 }, { 0 }, { false }, { true }, { true }, { true })
        val SCROLL_UP = UnassignedItemStack({ Material.PAPER }, {
            {
                key = "scroll_up"
                name = Component.text("Scroll up").color(NamedTextColor.GOLD)
            }
        }, { 1 }, { 0 }, { false }, { true }, { true }, { true })
        val SCROLL_RIGHT = UnassignedItemStack({ Material.PAPER }, {
            {
                key = "scroll_right"
                name = Component.text("Scroll right").color(NamedTextColor.GOLD)
            }
        }, { 1 }, { 0 }, { false }, { true }, { true }, { true })
        val SCROLL_LEFT = UnassignedItemStack({ Material.PAPER }, {
            {
                key = "scroll_left"
                name = Component.text("Scroll left").color(NamedTextColor.GOLD)
            }
        }, { 1 }, { 0 }, { false }, { true }, { true }, { true })
    }

    init {
        if (rows < 2 || rows > 5) throw IllegalArgumentException("Rows must be between 2 and 5")
    }

    var scrollIndex = mutableMapOf<UUID, Int>()
    val items = mutableMapOf<Int, UnassignedItemStack>()
    var scrolls = 0
    val itemsPerPage = (rows - 1) * 9
    val menuSlots = mutableListOf<Int>().apply {
        for (i in 0..8) {
            add((rows * 9) + i)
        }
    }

    suspend fun open(uniqueId: UUID, openPreviousPage: Boolean = false) {
        update()
        if (openPreviousPage && inventories.containsKey(uniqueId)) {
            inventories[uniqueId]!!.open()
            return
        }
        val inventory = Clients.INSTANCE.guiProvider.createInventory(uniqueId, this)
        inventories[uniqueId] = inventory
        scrollIndex[uniqueId] = 1

        var column = 0
        var row = 0
        items.forEach {
            if(scrollType == ScrollType.HORIZONTAL) {
                val slot = it.key
                if (menuSlots.contains(slot)) return@forEach
                inventory.items[slot] = it.value
            }else{
                row++
                if(row > rows-1) {
                    row = 0
                    column++
                }
                if(column > 8) return@forEach
                val slot = row * 9 + column
                inventory.items[slot] = it.value
            }
        }

        var menuIndex = 1
        menuSlots.forEach {
            menuIndex++
            when (menuIndex) {
                3 -> inventory.items[it] = if (scrollType == ScrollType.HORIZONTAL) SCROLL_LEFT else SCROLL_UP
                7 -> inventory.items[it] = if (scrollType == ScrollType.HORIZONTAL) SCROLL_RIGHT else SCROLL_DOWN
                else -> inventory.items[it] = PLACEHOLDER
            }
        }

        inventory.open()
    }

    suspend fun addItem(item: UnassignedItemStack) {
        val index = emptyIndex()
        items[index] = item
        update()
    }

    suspend fun removeItem(item: UnassignedItemStack) {
        items.forEach { (index, unassignedItemStack) ->
            if (unassignedItemStack == item) {
                items.remove(index)
                return@forEach
            }
        }
        update()
    }

    suspend fun scroll1(uuid: UUID) {
        scrollIndex[uuid] = scrollIndex[uuid]!! - 1
        update(uuid)
    }

    suspend fun scroll2(uuid: UUID) {
        scrollIndex[uuid] = scrollIndex[uuid]!! + 1
        update(uuid)
    }

    suspend override fun update() {
        calculatePageSize()
        recalculateIndex()
        super.update()
    }

    suspend override fun update(uniqueId: UUID) {
        if (inventories.containsKey(uniqueId)) {
            val inventory = inventories[uniqueId]!!
            val index = scrollIndex[uniqueId]!!
            val startIndex = (index - 1) * itemsPerPage
            val endIndex = startIndex + itemsPerPage
            val items = items.filterKeys { it in startIndex..endIndex }
            if (scrollType == ScrollType.HORIZONTAL) {
                items.forEach { (slot, unassignedItemStack) ->
                    inventory.items[slot] = unassignedItemStack
                }
            }else{
                var column = 0
                var row = 0
                items.forEach { (_, unassignedItemStack) ->
                    row++
                    if(row > rows-1) {
                        row = 0
                        column++
                    }
                    if(column > 8) return@forEach
                    val newSlot = row * 9 + column
                    inventory.items[newSlot] = unassignedItemStack
                }
            }
        }
        super.update(uniqueId)
    }

    private fun recalculateIndex() {
        val newItems = mutableMapOf<Int, UnassignedItemStack>()
        newItems.forEach { (index, unassignedItemStack) ->
            val newIndex = emptyIndex(newItems)
            newItems[newIndex] = unassignedItemStack
        }
        items.clear()
        items.putAll(newItems)
    }

    private fun calculatePageSize() {
        var p = 0
        var current = 0
        items.forEach { _, _ ->
            current++
            if (current == 9) {
                p++
                current = 0
            }
        }
        scrolls = p
    }

    private fun emptyIndex(map: MutableMap<Int, UnassignedItemStack> = this.items): Int {
        var i = 0
        while (map.containsKey(i)) i++
        return i
    }

}

enum class ScrollType {
    HORIZONTAL, VERTICAL;
}