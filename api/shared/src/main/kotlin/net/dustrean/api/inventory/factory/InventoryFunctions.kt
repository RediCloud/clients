package net.dustrean.api.inventory.factory

import net.dustrean.api.inventory.Inventory
import net.dustrean.api.inventory.factory.impl.DataInventoryFactory
import net.dustrean.api.inventory.factory.impl.InventoryFactory
import net.dustrean.api.item.enums.Material
import net.dustrean.api.item.factories.item
import net.kyori.adventure.text.Component
import java.util.UUID

inline fun inventory(lines: Int, noinline name: ((UUID) -> Component), crossinline apply: InventoryFactory.() -> Unit): InventoryFactory {
    return InventoryFactory(lines, name).apply(apply)
}
inline fun inventory(lines: Int, name: Component, crossinline apply: InventoryFactory.() -> Unit): InventoryFactory {
    return InventoryFactory(lines, name).apply(apply)
}

inline fun dataInventoryBorder(lines: Int, noinline name: ((UUID) -> Component), crossinline apply: DataInventoryFactory.() -> Unit, material: Material = Material.GRAY_STAINED_GLASS_PANE): DataInventoryFactory {
    return DataInventoryFactory(InventoryFactory(lines, name).apply {
        border = item(material) {
            this.name = Component.empty()
        }
    }).apply(apply)
}

inline fun dataInventory(layout: Inventory, crossinline apply: DataInventoryFactory.() -> Unit): DataInventoryFactory {
    return DataInventoryFactory(layout).apply(apply)
}