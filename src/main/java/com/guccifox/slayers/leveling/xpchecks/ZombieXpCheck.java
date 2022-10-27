package com.guccifox.slayers.leveling.xpchecks;

import com.guccifox.slayers.leveling.ZombieSlayerLevelManager;
import org.bukkit.entity.Player;

public class ZombieXpCheck {

    /**
     *
     * @param player player to check
     * @param zombieSlayerLevelManager enderman level manager
     */
    public static void xpCheckZombie(Player player, ZombieSlayerLevelManager zombieSlayerLevelManager) {
        // Get the players zombie xp
        int xp = zombieSlayerLevelManager.getXp();

        if (xp  >= zombieSlayerLevelManager.getNextLevelXpInt() ) {
            if (zombieSlayerLevelManager.getNextLevel() != zombieSlayerLevelManager.getMaxLevel()) {
                if (zombieSlayerLevelManager.getLevel() != zombieSlayerLevelManager.getNextLevel()) {
                    player.sendMessage("§a§lLVL UP! §5§l➜ §r§eZombie Slayer LVL " + zombieSlayerLevelManager.getNextLevel() + "!");
                    zombieSlayerLevelManager.setLevel(zombieSlayerLevelManager.getNextLevel());
                }
            } else {
                player.sendMessage("§eZombie Slayer LVL " + zombieSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + zombieSlayerLevelManager.getXpTillNextLevel() + " XP!");
            }
        } else {
            player.sendMessage("§eZombie Slayer LVL " + zombieSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + zombieSlayerLevelManager.getXpTillNextLevel() + " XP!");
        }
    }
}
