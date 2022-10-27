package com.guccifox.slayers.leveling.xpchecks;

import com.guccifox.slayers.leveling.EndermanSlayerLevelManager;
import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.leveling.SpiderSlayerLevelManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class EndermanXpCheck {

    /**
     *
     * @param player player to check
     * @param endermanSlayerLevelManager enderman level manager
     */
    public static void xpCheckEnderman(Player player, EndermanSlayerLevelManager endermanSlayerLevelManager) {
        // Get the players enderman xp
        int xp = endermanSlayerLevelManager.getXp();
        if (xp  >= endermanSlayerLevelManager.getNextLevelXpInt() ) {
            if (endermanSlayerLevelManager.getNextLevel() != endermanSlayerLevelManager.getMaxLevel()) {
                if (endermanSlayerLevelManager.getLevel() != endermanSlayerLevelManager.getNextLevel()) {

                    player.sendMessage("§a§lLVL UP! §5§l➜ §r§eEnderman Slayer LVL " + endermanSlayerLevelManager.getNextLevel() + "!");
                    endermanSlayerLevelManager.setLevel(endermanSlayerLevelManager.getNextLevel());
                }
            } else {
                player.sendMessage("§eEnderman Slayer LVL " + endermanSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + endermanSlayerLevelManager.getXpTillNextLevel() + " XP!");
            }
        } else {
            player.sendMessage("§eEnderman Slayer LVL " + endermanSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + endermanSlayerLevelManager.getXpTillNextLevel() + " XP!");
        }
    }
}
