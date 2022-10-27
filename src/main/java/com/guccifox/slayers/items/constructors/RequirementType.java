package com.guccifox.slayers.items.constructors;

import org.bukkit.ChatColor;

public enum RequirementType {
    SLAYER("☠"),
    COMBAT("❣"),
    CATACOMBS("❣");

    private final String icon;

    public String getIcon() {
        return ChatColor.RED + icon;
    }

    RequirementType(String icon) {
        this.icon = icon;
    }
}
