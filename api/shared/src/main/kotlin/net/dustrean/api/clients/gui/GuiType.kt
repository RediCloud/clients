package net.dustrean.api.clients.gui

enum class GuiType(val rows: Int, val rowSize: Int) {

    CHEST(5, 9),
    WORKBENCH(3, 3),
    HOPPER(1, 5),
    FURNACE(3, 1),
    DISPENSER(3, 3),
    ENCHANTING(2, 1),
    BREWING(1, 5),
    ANVIL(3, 1),
    BEACON(1, 1),
    SHULKER_BOX(3, 9),
    CARTOGRAPHY(3, 1),
    SMITHING(3, 1),
    LOOM(3, 1),
    GRINDSTONE(3, 1),
    STONECUTTER(3, 1),
    BARREL(3, 9),
    BLAST_FURNACE(3, 1),
    SMOKER(3, 1),
    CAMPFIRE(3, 1);

}