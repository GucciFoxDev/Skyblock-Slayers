package com.guccifox.slayers.slayers.zombie;

import com.guccifox.slayers.Slayers;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieSounds {

    public static void playSoundWithDelay(Player player, long delay, float pitch) {
        new BukkitRunnable() {

            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, pitch);
            }
        }.runTaskLater(Slayers.getPlugin(), delay);
    }

    public static void playSoundWithDelay(Player player, Sound sound, float vol, float pitch, long delay) {
        new BukkitRunnable() {

            @Override
            public void run() {
                player.playSound(player.getLocation(), sound, vol, pitch);
            }
        }.runTaskLater(Slayers.getPlugin(), delay);
    }
}
