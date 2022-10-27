package com.guccifox.slayers.leveling.xpchecks;

import com.guccifox.slayers.leveling.SpiderSlayerLevelManager;
import org.bukkit.entity.Player;

public class SpiderXpCheck {

    /**
     *
     * @param player player to check
     * @param spiderSlayerLevelManager enderman level manager
     */
    public static void xpCheckSpider(Player player, SpiderSlayerLevelManager spiderSlayerLevelManager) {
        // Get the players spider xp
        int xp = spiderSlayerLevelManager.getXp();

        if (xp  >= spiderSlayerLevelManager.getNextLevelXpInt() ) {
            if (spiderSlayerLevelManager.getNextLevel() != spiderSlayerLevelManager.getMaxLevel()) {
                if (spiderSlayerLevelManager.getLevel() != spiderSlayerLevelManager.getNextLevel()) {
                    player.sendMessage("§a§lLVL UP! §5§l➜ §r§eSpider Slayer LVL " + spiderSlayerLevelManager.getNextLevel() + "!");
                    spiderSlayerLevelManager.setLevel(spiderSlayerLevelManager.getNextLevel());
                }
            } else {
                player.sendMessage("§eSpider Slayer LVL " + spiderSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + spiderSlayerLevelManager.getXpTillNextLevel() + " XP!");
            }
        } else {
            player.sendMessage("§eSpider Slayer LVL " + spiderSlayerLevelManager.getLevel() + "§5 - " + "§7Next LVL in §d" + spiderSlayerLevelManager.getXpTillNextLevel() + " XP!");
        }
    }
}
