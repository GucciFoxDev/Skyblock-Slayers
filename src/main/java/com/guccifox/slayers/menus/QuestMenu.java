package com.guccifox.slayers.menus;

import com.guccifox.slayers.leveling.ZombieSlayerLevelManager;
import com.guccifox.slayers.leveling.xpchecks.ZombieXpCheck;
import com.guccifox.slayers.menus.handlers.Menu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.menus.primary.RevenantHorrorMenu;
import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.Slayers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuestMenu extends Menu {
    private final boolean openAfterDone;
    public static Map<Entity, Integer> zombieSlayerLevel = new HashMap<>();
    public static Map<Entity, Integer> zombieSlayerXP = new HashMap<>();

    public static Map<Entity, Integer> spiderSlayerLevel = new HashMap<>();
    public static Map<Entity, Integer> spiderSlayerXP = new HashMap<>();

    public static Map<Entity, Integer> wolfSlayerLevel = new HashMap<>();
    public static Map<Entity, Integer> wolfSlayerXP = new HashMap<>();

    public static Map<Entity, Integer> endermanSlayerLevel = new HashMap<>();
    public static Map<Entity, Integer> endermanSlayerXP = new HashMap<>();

    public static Map<Entity, Integer> blazeSlayerLevel = new HashMap<>();
    public static Map<Entity, Integer> blazeSlayerXP = new HashMap<>();
    public QuestMenu(PlayerMenuUtility playerMenuUtility, Boolean openAfterDone) {
        super(playerMenuUtility);
        this.openAfterDone = openAfterDone;
    }

    @Override
    public String getTitle() {
        return "Slayer";
    }

    @Override
    public int getSize() {
        return 36;
    }

    @Override
    public void hadleMenu(InventoryClickEvent event) {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ZombieSlayerLevelManager zombieSlayerLevelManager = Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.get(player.getUniqueId());
        Quest quest = new Quest();
        String[] lore = event.getInventory().getItem(13).getItemMeta().getLore().toArray(new String[0]);
        if (event.getSlot() == 13) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (Quest.questComplete.containsKey(player.getUniqueId())) {
                        if (Quest.questComplete.get(player.getUniqueId())) {
                            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "SLAYER QUEST COMPLETE!");
                            if (Quest.quest.get(player.getUniqueId()).toString().contains("ZOMBIE_SLAYER")) {
                                zombieSlayerLevelManager.setXp(zombieSlayerLevelManager.getXp() + quest.getType(player).getXp());
                                ZombieXpCheck.xpCheckZombie(player, zombieSlayerLevelManager);
                                ZombieSlayerLevelManager zombieSlayerLevelManager2 = Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.get(player.getUniqueId());

                                File playerData = new File("plugins/Hypixel_Slayers/playerData/" + player.getName().toString() + "-" + player.getUniqueId().toString() + "/data.yml");
                                FileConfiguration pD = YamlConfiguration.loadConfiguration(playerData);

                                if (Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.containsKey(player.getUniqueId())) {
                                    pD.set("slayers.zombie-slayer-level", zombieSlayerLevelManager2.getLevel());
                                    pD.set("slayers.zombie-slayer-xp", zombieSlayerLevelManager2.getXp());
                                    Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.remove(player.getUniqueId());
                                    try {
                                        pD.save(playerData);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                                Slayers.getPlugin().ZombieSlayerLevelManagerHashMap.put(player.getUniqueId(), new ZombieSlayerLevelManager(pD.getInt("slayers.zombie-slayer-level"), pD.getInt("slayers.zombie-slayer-xp")));

                                player.closeInventory();
                                player.playSound(player.getLocation(), Sound.LEVEL_UP, 10F, 1.5F);
                                Quest.cancelQuest(player);
                                Quest.questComplete.remove(player.getUniqueId());
                                if (openAfterDone) {
                                    new BukkitRunnable() {

                                        @Override
                                        public void run() {
                                            //new SlayersMenu(new PlayerMenuUtility(player)).open();
                                            new RevenantHorrorMenu(new PlayerMenuUtility(player)).open();
                                        }
                                    }.runTaskLater(Slayers.getPlugin(), 5L);
                                }
                            }

                        } else {
                            player.sendMessage(ChatColor.YELLOW + "Your unsuccessful quest has been cleared.");
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 10F, 1.5F);
                            Quest.cancelQuest(player);
                            Quest.questComplete.remove(player.getUniqueId());
                        }
                    } else {
                        new ConfirmMenu(new PlayerMenuUtility(player), "cancel_quest").open();
                    }
                }
            }.runTaskLater(Slayers.getPlugin(), 3);
        }
        if (event.getSlot() == 31) {
            player.closeInventory();
        }
    }

    @Override
    public void setItems() {
        Player player = playerMenuUtility.getOwner();

        setFilter();
        Quest quest = new Quest();
        ItemStack slayerQuest;

        ItemStack close = makeItem(Material.BARRIER, "§cClose", 1, 0);
        inventory.setItem(31, close);

        if (quest.getType(player).toString().contains("ZOMBIE")) {
            if (Quest.questComplete.containsKey(player.getUniqueId())) {
                if (!(Quest.questComplete.get(player.getUniqueId()))) {
                    slayerQuest = makeItem(Material.STAINED_CLAY, "§cSlayer Quest Failed", 1, 14,
                            "§7You didn't succeed in",
                            "§7killing the boss on your",
                            "§7last Slayer quest.",
                            "",
                            "§8It's not a big deal! You can",
                            "§8always try again!",
                            "",
                            "§eOk, thanks for reminding me!");
                    inventory.setItem(13, slayerQuest);
                    return;
                }

                slayerQuest = makeItem(Material.ROTTEN_FLESH, "§aSlayer Quest Complete!", 1, 0,
                        "§7You've slain the boss!",
                        "§7Skyblock is now a little",
                        "§7safter thanks to you!",
                        "",
                        "§7Boss: " + quest.getType(player).getDisplayname(),
                        "",
                        "§7Reward: §5" + quest.getType(player).getXp() + " Zombie Slayer XP",
                        "",
                        "§eClick to collect reward!");
                inventory.setItem(13, slayerQuest);
                return;
            }

            slayerQuest = makeItem(Material.ROTTEN_FLESH, "§aOngoing Slayer Quest", 1, 0,
                    "§7You have an active Slayer",
                    "§7quest.",
                    "",
                    "§7Boss: " + quest.getType(player).getDisplayname(),
                    "§eKill Zombies to spawn the boss!",
                    "",
                    "§bExample Monsters: ",
                    "§7Lv1 Zombie",
                    "§8Found in Hub!",
                    "",
                    "§eClick to cancel quest!");
            inventory.setItem(13, slayerQuest);

        } else if (quest.getType(player).toString().contains("SPIDER")) {
            if (Quest.questComplete.containsKey(player.getUniqueId())) {
                if (!(Quest.questComplete.get(player.getUniqueId()))) {
                    slayerQuest = makeItem(Material.STAINED_CLAY, "§cSlayer Quest Failed", 1, 14,
                            "§7You didn't succeed in",
                            "§7killing the boss on your",
                            "§7last Slayer quest.",
                            "",
                            "§8It's not a big deal! You can",
                            "§8always try again!",
                            "",
                            "§eOk, thanks for reminding me!");
                    inventory.setItem(13, slayerQuest);
                    return;
                }

                slayerQuest = makeItem(Material.WEB, "§aSlayer Quest Complete!", 1, 0,
                        "§7You've slain the boss!",
                        "§7Skyblock is now a little",
                        "§7safter thanks to you!",
                        "",
                        "§7Boss: " + quest.getType(player).getDisplayname(),
                        "",
                        "§7Reward: §55 Spider Slayer XP",
                        "",
                        "§eClick to collect reward!");
                inventory.setItem(13, slayerQuest);
                return;
            }

            slayerQuest = makeItem(Material.WEB, "§aOngoing Slayer Quest", 1, 0,
                    "§7You have an active Slayer",
                    "§7quest.",
                    "",
                    "§7Boss: " + quest.getType(player).getDisplayname(),
                    "§eKill Spiders to spawn the boss!",
                    "",
                    "§bExample Monsters: ",
                    "§7Lv1 Spider",
                    "§8Found in the Spider's Den!",
                    "",
                    "§eClick to cancel quest!");
            inventory.setItem(13, slayerQuest);

        } else if (quest.getType(player).toString().contains("WOLF")) {
            if (Quest.questComplete.containsKey(player.getUniqueId())) {
                if (!(Quest.questComplete.get(player.getUniqueId()))) {
                    slayerQuest = makeItem(Material.STAINED_CLAY, "§cSlayer Quest Failed", 1, 14,
                            "§7You didn't succeed in",
                            "§7killing the boss on your",
                            "§7last Slayer quest.",
                            "",
                            "§8It's not a big deal! You can",
                            "§8always try again!",
                            "",
                            "§eOk, thanks for reminding me!");
                    inventory.setItem(13, slayerQuest);
                    return;
                }

                slayerQuest = makeItem(Material.MUTTON, "§aSlayer Quest Complete!", 1, 0,
                        "§7You've slain the boss!",
                        "§7Skyblock is now a little",
                        "§7safter thanks to you!",
                        "",
                        "§7Boss: " + quest.getType(player).getDisplayname(),
                        "",
                        "§7Reward: §55 Wolf Slayer XP",
                        "",
                        "§eClick to collect reward!");
                inventory.setItem(13, slayerQuest);
                return;
            }

            slayerQuest = makeItem(Material.MUTTON, "§aOngoing Slayer Quest", 1, 0,
                    "§7You have an active Slayer",
                    "§7quest.",
                    "",
                    "§7Boss: " + quest.getType(player).getDisplayname(),
                    "§eKill Wolfs to spawn the boss!",
                    "",
                    "§bExample Monsters: ",
                    "§7Lv1 Wolf",
                    "§8Found in Hub!",
                    "",
                    "§eClick to cancel quest!");
            inventory.setItem(13, slayerQuest);
        }
    }
}
