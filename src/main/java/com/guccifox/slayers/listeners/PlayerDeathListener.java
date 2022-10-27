package com.guccifox.slayers.listeners;

import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import com.guccifox.slayers.quests.Quest;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (!(ZombieSlayerBoss.bossMap.containsKey(player.getUniqueId()))) return;

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + " SLAYER QUEST FAILED!");
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + " »" + ChatColor.GRAY + "You died! Learn to play the game before fighting this!");
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10F, 0.5F);

        Quest.questComplete.put(player.getUniqueId(), false);
        Quest.fightingBoss.remove(player.getUniqueId());
        ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());
    }
}
