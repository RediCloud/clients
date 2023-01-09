package net.dustrean.api.clients.gui.impl

import net.dustrean.api.clients.Clients
import net.dustrean.api.gui.Gui
import net.dustrean.api.gui.GuiType
import net.dustrean.api.item.UnassignedItemStack
import net.dustrean.api.item.enums.Material
import net.dustrean.api.language.component.inventory.InventoryComponentProvider
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import java.util.*

class PaginatedGui(
    rows: Int,
    languageProvider: (UUID) -> InventoryComponentProvider.() -> Unit,
) : Gui(
    GuiType.CHEST, rows, languageProvider
) {

    companion object {
        val PLACEHOLDER =  UnassignedItemStack(
            { Material.PAPER },
            {{
                key = "placeholder"
                name = Component.empty().color(NamedTextColor.GOLD)
            } },
            { 1 },
            { 0 },
            { false },
            { true },
            { true },
            { true }
        )
        val NEXT_PAGE = UnassignedItemStack(
            { Material.PAPER },
            {{
                key = "next_page"
                name = Component.text("Next page").color(NamedTextColor.GOLD)
            } },
            { 1 },
            { 0 },
            { false },
            { true },
            { true },
            { true }
        )
        val PREVIOUS_PAGE = UnassignedItemStack(
            { Material.PAPER },
            {{
                key = "previous_page"
                name = Component.text("Previous page").color(NamedTextColor.GOLD)
            } },
            { 1 },
            { 0 },
            { false },
            { true },
            { true },
            { true }
        )
    }

    init {
        if (rows < 2 || rows > 5) throw IllegalArgumentException("Rows must be between 2 and 5")
    }

    var currentPage = mutableMapOf<UUID, Int>()
    val items = mutableMapOf<Int, UnassignedItemStack>()
    var pages = 0
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
        val inventory = net.dustrean.api.clients.Clients.INSTANCE.guiProvider.createInventory(uniqueId, this)
        inventories[uniqueId] = inventory
        currentPage[uniqueId] = 1

        items.forEach {
            val slot = it.key
            if (menuSlots.contains(slot)) return@forEach
            inventory.items[slot] = it.value
        }

        var menuIndex = 1
        menuSlots.forEach {
            menuIndex++
            when (menuIndex) {
                3 -> inventory.items[it] = PREVIOUS_PAGE
                7 -> inventory.items[it] = NEXT_PAGE
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

    suspend fun nextPage(uuid: UUID) {
        if(currentPage[uuid]!!+1 > pages) return
        currentPage[uuid] = currentPage[uuid]!! + 1
        update(uuid)
    }

    suspend fun previousPage(uuid: UUID) {
        if(currentPage[uuid]!!-1 > 1) return
        currentPage[uuid] = currentPage[uuid]!! - 1
        update(uuid)
    }

    override suspend fun update() {
        calculatePageSize()
        recalculateIndex()
        super.update()
    }

    override suspend fun update(uniqueId: UUID) {
        if (inventories.containsKey(uniqueId)) {
            val inventory = inventories[uniqueId]!!
            val page = currentPage[uniqueId]!!
            val startIndex = (page - 1) * itemsPerPage
            val endIndex = startIndex + itemsPerPage
            val items = items.filterKeys { it in startIndex..endIndex }
            items.forEach { (slot, unassignedItemStack) ->
                inventory.items[slot] = unassignedItemStack
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
        var p = 1
        var current = 0
        items.forEach { (_, _) ->
            current++
            if (current == itemsPerPage) {
                p++
                current = 0
            }
        }
        pages = p
    }

    private fun emptyIndex(map: MutableMap<Int, UnassignedItemStack> = this.items): Int {
        var i = 0
        while (map.containsKey(i)) i++
        return i
    }

}