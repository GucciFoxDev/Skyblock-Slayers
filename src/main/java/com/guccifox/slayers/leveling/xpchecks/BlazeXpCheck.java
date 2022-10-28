package com.guccifox.slayers.leveling.xpchecks;

import com.guccifox.slayers.leveling.BlazeSlayerLevelManager;
import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.leveling.EndermanSlayerLevelManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BlazeXpCheck {

    /**
     *
     * @param player player to check
     * @param blazeSlayerLevelManager blaze level manager
     */
    public static void xpCheckBlaze(Player player, BlazeSlayerLevelManager blazeSlayerLevelManager) {
        // Get the players blaze xp
        int xp = blazeSlayerLevelManager.getXp();

        if (xp  >= blazeSlayerLevelManager.getNextLevelXpInt() ) {
            if (blazeSlayerLevelManager.getNextLevel() != blazeSlayerLevelManager.getMaxLevel()) {
                if (blazeSlayerLevelManager.getLevel() != blazeSlayerLevelManager.getNextLevel()) {
                    player.sendMessage("§a§lLVL UP! §5§l➜ §r§eBlaze Slayer LVL " + blazeSlayerLevelManager.getNextLevel() + "!");
                    blazeSlayerLevelManager.setLevel(blazeSlayerLevelManager.getNextLevel());
                }
            } else {
                player.sendMessage("§eBlaze Slayer LVL " + blazeSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + blazeSlayerLevelManager.getXpTillNextLevel() + " XP!");
            }
        } else {
            player.sendMessage("§eBlaze Slayer LVL " + blazeSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + blazeSlayerLevelManager.getXpTillNextLevel() + " XP!");
        }
    }
}
