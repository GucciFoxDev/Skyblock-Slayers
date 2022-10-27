package com.guccifox.slayers.listeners;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.leveling.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void onQuit(org.bukkit.event.player.PlayerQuitEvent event) throws IOException {
        Player player = event.getPlayer();

        File playerData = new File("plugins/Hypixel_Slayers/playerData/" + player.getName().toString() + "-" + player.getUniqueId().toString() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

        // Save zombie slayer
        ZombieSlayerLevelManager zombieSlayerLevelManager = Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.get(player.getUniqueId());

        if (Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
            pD.set("slayers.zombie-slayer-level", zombieSlayerLevelManager.getLevel());
            pD.set("slayers.zombie-slayer-xp", zombieSlayerLevelManager.getXp());
            pD.save(playerData);
            Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.remove(player.getUniqueId());
        }

        // Save spider slayer
        SpiderSlayerLevelManager spiderSlayerLevelManager = Slayers.getPlugin().SpiderSlayerLevelManagerHashMap.get(player.getUniqueId());

        if (Slayers.getPlugin().SpiderSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
            pD.set("slayers.spider-slayer-level", spiderSlayerLevelManager.getLevel());
            pD.set("slayers.spider-slayer-xp", spiderSlayerLevelManager.getXp());
            pD.save(playerData);
            Slayers.getPlugin().SpiderSlayerLevelManagerHashMap.remove(player.getUniqueId());
        }

        // Save wolf slayer
        WolfSlayerLevelManager wolfSlayerLevelManager = Slayers.getPlugin().WolfSlayerLevelManagerHashMap.get(player.getUniqueId());

        if (Slayers.getPlugin().WolfSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
            pD.set("slayers.wolf-slayer-level", wolfSlayerLevelManager.getLevel());
            pD.set("slayers.wolf-slayer-xp", wolfSlayerLevelManager.getXp());
            pD.save(playerData);
            Slayers.getPlugin().WolfSlayerLevelManagerHashMap.remove(player.getUniqueId());
        }

        // Save enderman slayer
        EndermanSlayerLevelManager endermanSlayerLevelManager = Slayers.getPlugin().EndermanSlayerLevelManagerHashMap.get(player.getUniqueId());

        if (Slayers.getPlugin().EndermanSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
            pD.set("slayers.enderman-slayer-level", endermanSlayerLevelManager.getLevel());
            pD.set("slayers.enderman-slayer-xp", endermanSlayerLevelManager.getXp());
            pD.save(playerData);
            Slayers.getPlugin().EndermanSlayerLevelManagerHashMap.remove(player.getUniqueId());
        }

        // Save blaze slayer
        BlazeSlayerLevelManager blazeSlayerLevelManager = Slayers.getPlugin().BlazeSlayerLevelManagerHashMap.get(player.getUniqueId());

        if (Slayers.getPlugin().BlazeSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
            pD.set("slayers.blaze-slayer-level", blazeSlayerLevelManager.getLevel());
            pD.set("slayers.blaze-slayer-xp", blazeSlayerLevelManager.getXp());
            pD.save(playerData);
            Slayers.getPlugin().BlazeSlayerLevelManagerHashMap.remove(player.getUniqueId());
        }
    }
}
