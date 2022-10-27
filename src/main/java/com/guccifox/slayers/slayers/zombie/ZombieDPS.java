package com.guccifox.slayers.slayers.zombie;

import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.Slayers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ZombieDPS {
    private final Player player;
    private final double damage;
    int i = 0;

    public ZombieDPS(Player player, double damage) {
        this.player = player;
        this.damage = damage;
    }

    public void start() {
        i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (!(Quest.fightingBoss.containsKey(player.getUniqueId()))) return;

                player.damage(damage);
            }
        }, 0, 20L);
    }

    public void stop() {
        Bukkit.getScheduler().cancelTask(i);
    }
}
