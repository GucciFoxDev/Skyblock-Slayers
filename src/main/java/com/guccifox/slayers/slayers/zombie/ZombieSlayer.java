package com.guccifox.slayers.slayers.zombie;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import com.guccifox.slayers.quests.Quest;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieSlayer {

    public ZombieSlayer (Player player, Location entityLoc, ZombieSlayerBoss boss, Boolean playSpawnSound, Boolean startDPS, Double DPS) {

        // Summon boss and play the wither sound
        if (!(Quest.fightingBoss.containsKey(player.getUniqueId()))) {
            if (!(Quest.questComplete.containsKey(player.getUniqueId()))) {
                if (playSpawnSound) {
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 1);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 4);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 7);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 10);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 13);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 16);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 19);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 22);
                    ZombieSounds.playSoundWithDelay(player, Sound.WITHER_SHOOT, 1f, 1.5f, 25);
                }
                //SlayerBoss.playBossSpawnEffect(event.getEntity().getLocation());
                Quest.fightingBoss.put(player.getUniqueId(), true);

                // Start dps and create summoning effect
                if (startDPS) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage(ChatColor.GREEN + "The slayer boss has spawned! SLAY THE BOSS!");
                            player.getWorld().playEffect(entityLoc, Effect.EXPLOSION_HUGE, 1);
                            player.playSound(player.getLocation(), Sound.EXPLODE, 10F, 1);
                            ZombieSlayerBoss.spawnZombieSlayerBoss(boss, entityLoc, player);
                            player.getWorld().playSound(entityLoc, Sound.WITHER_SPAWN, 1f, 1f);

                            ZombieDPS dps = new ZombieDPS(player, DPS);
                            dps.start();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 27L);
                }
                return;
            }
        }
    }
}
