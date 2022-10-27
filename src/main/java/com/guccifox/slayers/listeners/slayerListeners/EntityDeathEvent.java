package com.guccifox.slayers.listeners.slayerListeners;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import com.guccifox.slayers.slayers.zombie.ZombieSlayer;
import com.guccifox.slayers.slayers.zombie.ZombieSounds;
import com.guccifox.slayers.items.CustomItem;
import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.quests.QuestType;
import com.guccifox.slayers.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class EntityDeathEvent implements Listener {
    public static HashMap<UUID, Integer> combat_exp = new HashMap<>();
    private int XPfromZombie = 100;

    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;
        Player player = event.getEntity().getKiller();

        HashMap<UUID, QuestType> playerQuest = Quest.getQuest(player);
        Quest quest = new Quest();
        if (!(playerQuest.containsKey(player.getUniqueId()))) return;
        if (quest.getType(player) == null) return;
        if (event.getEntity().getType() == EntityType.ZOMBIE) {

            // Just checking if they are fighting a slayer boss
            if (Quest.fightingBoss.containsKey(player.getUniqueId())) {
                if (ZombieSlayerBoss.bossMap.get(player.getUniqueId()) == event.getEntity()) {

                    // Tier 1 zombie/revenant slayer killed
                    if (event.getEntity().getEquipment().getHelmet().getItemMeta().getDisplayName().equals("ZOMBIE_SLAYER_TIER_1")) {
                        // Send the messages and play the sound
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "  NICE! SLAYER BOSS SLAIN!");
                        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "  » " + ChatColor.GRAY + "Talk to Maddox to claim your Zombie Slayer XP!");
                        ZombieSounds.playSoundWithDelay(player, 3L, 1);
                        ZombieSounds.playSoundWithDelay(player, 7, 1.5f);
                        ZombieSounds.playSoundWithDelay(player, 11, 2f);

                        Quest.questComplete.put(player.getUniqueId(), true);
                        Quest.fightingBoss.remove(player.getUniqueId());
                        if (!(ZombieSlayerBoss.bossMap.get(player.getUniqueId()).isDead())) ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());

                        // Add the items to the drops
                        int stack5 = Utilities.getRandomInrange(1, 3);
                        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), "REVENANT_FLESH", stack5);
                        event.getDrops();
                        event.getDrops().clear();
                        event.getDrops().add(itemStack);
                        return;
                    }

                    // Tier 2 zombie/revenant slayer killed
                    if (event.getEntity().getEquipment().getHelmet().getItemMeta().getDisplayName().equals("ZOMBIE_SLAYER_TIER_2")) {
                        // Send the messages and play the sound
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "  NICE! SLAYER BOSS SLAIN!");
                        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "  » " + ChatColor.GRAY + "Talk to Maddox to claim your Zombie Slayer XP!");
                        ZombieSounds.playSoundWithDelay(player, 3L, 1);
                        ZombieSounds.playSoundWithDelay(player, 7, 1.5f);
                        ZombieSounds.playSoundWithDelay(player, 11, 2f);

                        Quest.questComplete.put(player.getUniqueId(), true);
                        Quest.fightingBoss.remove(player.getUniqueId());
                        if (!(ZombieSlayerBoss.bossMap.get(player.getUniqueId()).isDead())) ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());

                        // Add the items to the drops
                        int revFleshStack = Utilities.getRandomInrange(9, 18);
                        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), "REVENANT_FLESH", revFleshStack);
                        event.getDrops();
                        event.getDrops().clear();
                        event.getDrops().add(itemStack);
                        return;
                    }

                    // Tier 3 zombie/revenant slayer killed
                    if (event.getEntity().getEquipment().getHelmet().getItemMeta().getDisplayName().equals("ZOMBIE_SLAYER_TIER_3")) {
                        // Send the messages and play the sound
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "  NICE! SLAYER BOSS SLAIN!");
                        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "  » " + ChatColor.GRAY + "Talk to Maddox to claim your Zombie Slayer XP!");
                        ZombieSounds.playSoundWithDelay(player, 3L, 1);
                        ZombieSounds.playSoundWithDelay(player, 7, 1.5f);
                        ZombieSounds.playSoundWithDelay(player, 11, 2f);

                        Quest.questComplete.put(player.getUniqueId(), true);
                        Quest.fightingBoss.remove(player.getUniqueId());
                        if (!(ZombieSlayerBoss.bossMap.get(player.getUniqueId()).isDead())) ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());

                        // Add the items to the drops
                        int stack = Utilities.getRandomInrange(30, 50);
                        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), "REVENANT_FLESH", stack);
                        event.getDrops();
                        event.getDrops().clear();
                        event.getDrops().add(itemStack);
                        return;
                    }

                    // Tier 4 zombie/revenant slayer killed
                    if (event.getEntity().getEquipment().getHelmet().getItemMeta().getDisplayName().equals("ZOMBIE_SLAYER_TIER_4")) {
                        // Send the messages and play the sound
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "  NICE! SLAYER BOSS SLAIN!");
                        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "  » " + ChatColor.GRAY + "Talk to Maddox to claim your Zombie Slayer XP!");
                        ZombieSounds.playSoundWithDelay(player, 3L, 1);
                        ZombieSounds.playSoundWithDelay(player, 7, 1.5f);
                        ZombieSounds.playSoundWithDelay(player, 11, 2f);

                        Quest.questComplete.put(player.getUniqueId(), true);
                        Quest.fightingBoss.remove(player.getUniqueId());
                        if (!(ZombieSlayerBoss.bossMap.get(player.getUniqueId()).isDead())) ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());

                        // Add the items to the drops
                        int stack2 = Utilities.getRandomInrange(50, 64);
                        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), "REVENANT_FLESH", stack2);
                        event.getDrops();
                        event.getDrops().clear();
                        event.getDrops().add(itemStack);
                        return;
                    }

                    // Tier 5 zombie/revenant slayer killed
                    if (event.getEntity().getEquipment().getHelmet().getItemMeta().getDisplayName().equals("ZOMBIE_SLAYER_TIER_5")) {
                        // Send the messages and play the sound
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "  NICE! SLAYER BOSS SLAIN!");
                        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "  » " + ChatColor.GRAY + "Talk to Maddox to claim your Zombie Slayer XP!");
                        ZombieSounds.playSoundWithDelay(player, 3L, 1);
                        ZombieSounds.playSoundWithDelay(player, 7, 1.5f);
                        ZombieSounds.playSoundWithDelay(player, 11, 2f);

                        Quest.questComplete.put(player.getUniqueId(), true);
                        Quest.fightingBoss.remove(player.getUniqueId());
                        if (!(ZombieSlayerBoss.bossMap.get(player.getUniqueId()).isDead())) ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());

                        // Add the items to the drops
                        int stack3 = Utilities.getRandomInrange(63, 64);
                        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), "REVENANT_FLESH", stack3);
                        event.getDrops();
                        event.getDrops().clear();
                        event.getDrops().add(itemStack);
                        return;
                    }
                } else {
                    return;
                }
                return;
            }


            // If their quest is zombie/revenant slayer tier 1
            if (quest.getType(player).equals(QuestType.ZOMBIE_SLAYER_TIER_1)) {

                // Add combat xp
                if (combat_exp.containsKey(player.getUniqueId())) {
                    combat_exp.put(player.getUniqueId(), combat_exp.get(player.getUniqueId()) + XPfromZombie);
                    if (combat_exp.get(player.getUniqueId()) < 150) {
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 2);
                        Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/150)");
                    } else if (combat_exp.get(player.getUniqueId()) >= 150) {

                        new ZombieSlayer(player, event.getEntity().getLocation(), ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_1, true, true, 0.5d);
                    }
                    return;
                }
                combat_exp.put(player.getUniqueId(), XPfromZombie);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 0);
                Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/150)");

            // If their quest is zombie/revenant slayer tier 2
            } else if (quest.getType(player).equals(QuestType.ZOMBIE_SLAYER_TIER_2)) {
                if (combat_exp.containsKey(player.getUniqueId())) {
                    if (combat_exp.get(player.getUniqueId())  < 1440) {
                        combat_exp.put(player.getUniqueId(), combat_exp.get(player.getUniqueId()) + XPfromZombie);
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 2);
                        Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/1440)");
                    } else if (combat_exp.get(player.getUniqueId()) >= 1440) {

                        new ZombieSlayer(player, event.getEntity().getLocation(), ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_2, true, true, 0.5d);
                    }
                    return;
                }
                combat_exp.put(player.getUniqueId(), XPfromZombie);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 0);
                Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/1440)");

            // If their quest is zombie/revenant slayer tier 3
            } else if (quest.getType(player).equals(QuestType.ZOMBIE_SLAYER_TIER_3)) {
                if (combat_exp.containsKey(player.getUniqueId())) {
                    if (combat_exp.get(player.getUniqueId())  < 2400) {
                        combat_exp.put(player.getUniqueId(), combat_exp.get(player.getUniqueId()) + XPfromZombie);
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 2);
                        Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/2400)");
                    } else if (combat_exp.get(player.getUniqueId()) >= 2400) {

                        new ZombieSlayer(player, event.getEntity().getLocation(), ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_3, true, true, 1.0d);
                    }
                    return;
                }
                combat_exp.put(player.getUniqueId(), XPfromZombie);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 0);
                Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/2400)");

            // If their quest is zombie/revenant slayer tier 4
            } else if (quest.getType(player).equals(QuestType.ZOMBIE_SLAYER_TIER_4)) {
                if (combat_exp.containsKey(player.getUniqueId())) {
                    if (combat_exp.get(player.getUniqueId())  < 4800) {
                        combat_exp.put(player.getUniqueId(), combat_exp.get(player.getUniqueId()) + XPfromZombie);
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 2);
                        Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/4800)");
                    } else if (combat_exp.get(player.getUniqueId()) >= 4800) {

                        new ZombieSlayer(player, event.getEntity().getLocation(), ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_4, true, true, 2.5d);
                    }
                    return;
                }
                combat_exp.put(player.getUniqueId(), XPfromZombie);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 0);
                Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/4800)");

            // If their quest is zombie/revenant slayer tier 5
            }  else if (quest.getType(player).equals(QuestType.ZOMBIE_SLAYER_TIER_5)) {
                if (combat_exp.containsKey(player.getUniqueId())) {
                    if (combat_exp.get(player.getUniqueId())  < 6000) {
                        combat_exp.put(player.getUniqueId(), combat_exp.get(player.getUniqueId()) + XPfromZombie);
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 2);
                        Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/6000)");
                    } else if (combat_exp.get(player.getUniqueId()) >= 6000) {

                        new ZombieSlayer(player, event.getEntity().getLocation(), ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_5, true, true, 2.5d);
                    }
                    return;
                }
                combat_exp.put(player.getUniqueId(), XPfromZombie);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 10F, 0);
                Utilities.sendActionbar(player, "&3+6 Combat (" + combat_exp.get(player.getUniqueId()) + "/6000)");
            }
        } // else if its spider or wolf
    }
}
