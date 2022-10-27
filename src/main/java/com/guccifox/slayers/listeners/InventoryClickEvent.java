package com.guccifox.slayers.listeners;

import com.guccifox.slayers.menus.handlers.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.InventoryHolder;

public class InventoryClickEvent implements Listener {
    @EventHandler
    public void onClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu) {
                Menu menu = (Menu) holder;
                menu.hadleMenu(event);
        }
    }
}
