package com.guccifox.slayers.utilities;

import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DropUtilities {

    /**
     *
     * @param itemToDrop item to add to the drop
     * @param chanceToDrop chance to drop the item (example: 0.5, 50, 5)
     * @param event entity death event
     */
    public void AddDrop(ItemStack itemToDrop, Integer chanceToDrop, EntityDeathEvent event) {
        if (Math.random() < chanceToDrop/100) {
            event.getDrops();
            event.getDrops().clear();
            event.getDrops().add(itemToDrop);
        }
    }
}
