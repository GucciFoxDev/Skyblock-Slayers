package com.guccifox.slayers.listeners;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.leveling.*;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class PlayerJoinEvent implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event) throws IOException, InvalidConfigurationException {
        Player player = event.getPlayer();

        // Create player data file
        File playerData = new File("plugins/Hypixel_Slayers/playerData/" + player.getName().toString() + "-" + player.getUniqueId().toString() + "/data.yml");
        FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);
        if (!(new File("plugins/Hypixel_Slayers/playerData/" + player.getName().toString() + "-" +player.getUniqueId().toString())).exists()) {
            (new File("plugins/Hypixel_Slayers/playerData/" + player.getName().toString() + "-" + player.getUniqueId().toString())).mkdir();
        }

        // Create the file if it doesn't exist
        if (!playerData.exists()) {
            playerData.getParentFile().mkdirs();
            playerData.createNewFile();
            pD.set("slayers.zombie-slayer-level", 0);
            pD.set("slayers.zombie-slayer-xp", 0);
            pD.set("slayers.spider-slayer-level", 0);
            pD.set("slayers.spider-slayer-xp", 0);
            pD.set("slayers.wolf-slayer-level", 0);
            pD.set("slayers.wolf-slayer-xp", 0);
            pD.set("slayers.enderman-slayer-level", 0);
            pD.set("slayers.enderman-slayer-xp", 0);
            pD.set("slayers.blaze-slayer-level", 0);
            pD.set("slayers.blaze-slayer-xp", 0);
            pD.save(playerData);
        }

        // If they haven't played set the hashmaps as level 0 and 0 xp
        if (!player.hasPlayedBefore()) {
            Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.put(player.getUniqueId(), new ZombieSlayerLevelManager(0, 0));
            Slayers.getPlugin().SpiderSlayerLevelManagerHashMap.put(player.getUniqueId(), new SpiderSlayerLevelManager(0, 0));
            Slayers.getPlugin().WolfSlayerLevelManagerHashMap.put(player.getUniqueId(), new WolfSlayerLevelManager(0, 0));
            Slayers.getPlugin().EndermanSlayerLevelManagerHashMap.put(player.getUniqueId(), new EndermanSlayerLevelManager(0, 0));
            Slayers.getPlugin().BlazeSlayerLevelManagerHashMap.put(player.getUniqueId(), new BlazeSlayerLevelManager(0, 0));
            pD.save(playerData);
        } else {
            // Define levels and xp
            int zombielevel = pD.getInt("slayers.zombie-slayer-level");
            int zombiexp = pD.getInt("slayers.zombie-slayer-xp");
            int spiderlevel = pD.getInt("slayers.spider-slayer-level");
            int spiderxp = pD.getInt("slayers.spider-slayer-xp");
            int wolflevel = pD.getInt("slayers.wolf-slayer-level");
            int wolfxp = pD.getInt("slayers.wolf-slayer-xp");
            int endermanlevel = pD.getInt("slayers.enderman-slayer-level");
            int endermanxp = pD.getInt("slayers.enderman-slayer-xp");
            int blazelevel = pD.getInt("slayers.blaze-slayer-level");
            int blazexp = pD.getInt("slayers.blaze-slayer-xp");

            // Set hashmaps
            Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.put(player.getUniqueId(), new ZombieSlayerLevelManager(zombielevel, zombiexp));
            Slayers.getPlugin().SpiderSlayerLevelManagerHashMap.put(player.getUniqueId(), new SpiderSlayerLevelManager(spiderlevel, spiderxp));
            Slayers.getPlugin().WolfSlayerLevelManagerHashMap.put(player.getUniqueId(), new WolfSlayerLevelManager(wolflevel, wolfxp));
            Slayers.getPlugin().EndermanSlayerLevelManagerHashMap.put(player.getUniqueId(), new EndermanSlayerLevelManager(endermanlevel, endermanxp));
            Slayers.getPlugin().BlazeSlayerLevelManagerHashMap.put(player.getUniqueId(), new BlazeSlayerLevelManager(blazelevel, blazexp));
            pD.save(playerData);
        }
    }
}
