package com.guccifox.slayers.leveling.xpchecks;

import com.guccifox.slayers.leveling.WolfSlayerLevelManager;
import org.bukkit.entity.Player;

public class WolfXpCheck {

    /**
     *
     * @param player player to check
     * @param wolfSlayerLevelManager enderman level manager
     */
    public static void xpCheckWolf(Player player, WolfSlayerLevelManager wolfSlayerLevelManager) {
        // Get the players wolf xp
        int xp = wolfSlayerLevelManager.getXp();

        if (xp  >= wolfSlayerLevelManager.getNextLevelXpInt() ) {
            if (wolfSlayerLevelManager.getNextLevel() != wolfSlayerLevelManager.getMaxLevel()) {
                if (wolfSlayerLevelManager.getLevel() != wolfSlayerLevelManager.getNextLevel()) {
                    player.sendMessage("§a§lLVL UP! §5§l➜ §r§eWolf Slayer LVL " + wolfSlayerLevelManager.getNextLevel() + "!");
                    wolfSlayerLevelManager.setLevel(wolfSlayerLevelManager.getNextLevel());
                }
            } else {
                player.sendMessage("§eWolf Slayer LVL " + wolfSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + wolfSlayerLevelManager.getXpTillNextLevel() + " XP!");
            }
        } else {
            player.sendMessage("§eWolf Slayer LVL " + wolfSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + wolfSlayerLevelManager.getXpTillNextLevel() + " XP!");
        }
    }
}
