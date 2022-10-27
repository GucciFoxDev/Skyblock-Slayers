package com.guccifox.slayers.menus.primary;

import com.guccifox.slayers.menus.ConfirmMenu;
import com.guccifox.slayers.menus.handlers.Menu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.menus.primary.SlayersMenu;
import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.Slayers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class TarantulaBroodfatherMenu extends Menu {
    public TarantulaBroodfatherMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getTitle() {
        return "Tarantula Broodfather";
    }

    @Override
    public int getSize() {
        return 54;
    }

    @Override
    public void hadleMenu(InventoryClickEvent event) {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "§aGo back":
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        new SlayersMenu(new PlayerMenuUtility(player)).open();
                    }
                }.runTaskLater(Slayers.getPlugin(), 3L);

                break;
            case "§aTarantula Broodfather I":
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_spider_1").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);
                }
                break;
            case "§eTarantula Broodfather II": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_spider_2").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);

                }
                break;
            }

            case "§cTarantula Broodfather III": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_spider_3").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);

                }
                break;
            }
            case "§4Tarantula Broodfather IV": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_spider_4").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);
                }
                break;
            }
        }
    }

    @Override
    public void setItems() {
        setFilter();
        ItemStack tier1 = makeItem(Material.WEB, "§aTarantula Broodfather I", 1, 0,
                "§8Beginner",
                "",
                "§7Health: §c750❤",
                "§7Damage: §c35 §7per second",
                "",
                "§eCombat Jump",
                "§7The spider will often attempt to",
                "jump behind you.",
                "",
                "§7Reward: §d6 Spider Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §61,000 coins",
                "",
                "§eClick to slay!");
        inventory.setItem(11, tier1);

        ItemStack tier2 = makeItem(Material.WEB, "§eTarantula Broodfather II", 2, 0,
                "§8Strong",
                "",
                "§7Health: §c30,000❤",
                "§7Damage: §c45 §7per second",
                "",
                "§eCombat Jump",
                "§7The spider will often attempt to",
                "jump behind you.",
                "",
                "§cNoxious",
                "§7Deals AOE damage every second,",
                "§7reducing your healing by 50%.",
                "",
                "§7Reward: §d31 Spider Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §63,750 coins",
                "",
                "§eClick to slay!");
        inventory.setItem(12, tier2);

        ItemStack tier3 = makeItem(Material.WEB, "§cTarantula Broodfather III", 3, 0,
                "§8Challenging",
                "",
                "§7Health: §c900,000❤",
                "§7Damage: §c210 §7per second",
                "",
                "§eCombat Jump",
                "§7The spider will often attempt to",
                "jump behind you.",
                "",
                "§cNoxious",
                "§7Deals AOE damage every second,",
                "§7reducing your healing by 50%.",
                "",
                "§7Reward: §d125 Spider Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §610,000 coins",
                "",
                "§eClick to slay!");

        ItemStack tier4 = makeItem(Material.WEB, "§4Tarantula Broodfather IV", 4, 0,
                "§8Debilitating",
                "",
                "§7Health: §c2,400,000❤",
                "§7Damage: §c530 §7per second",
                "",
                "§eCombat Jump",
                "§7The spider will often attempt to",
                "jump behind you.",
                "",
                "§cNoxious",
                "§7Deals AOE damage every second,",
                "§7reducing your healing by 50%.",
                "",
                "§7Reward: §d625 Spider Slayer XP",
                "§8 + Boss Drops",
                "",
                "§7Cost to start: §625,000 coins",
                "",
                "§eClick to slay!");

        ItemStack comingSoon = makeItem(Material.COAL_BLOCK, "§5Tarantula Broodfather", 1, 0,
                "§7This unimaginably difficult",
                "§7boss tier will release at a",
                "§7later date.");

        inventory.setItem(13, tier3);
        inventory.setItem(14, tier4);
        inventory.setItem(15, comingSoon);

        ItemStack back = makeItem(Material.ARROW, "§aGo back", 1, 0, "§7To Slayer");
        inventory.setItem(49, back);

        ItemStack progress = makeItem(Material.GOLD_BLOCK, "§5Boss Leveling Rewards", 1, 0,
                ChatColor.DARK_GRAY + "Spider Slayer LVL",
                "",
                ChatColor.DARK_PURPLE + "1. " + ChatColor.GRAY + "Kill boss to get XP",
                ChatColor.DARK_PURPLE + "2. " + ChatColor.GRAY + "Gain LVL from XP",
                ChatColor.DARK_PURPLE + "3. " + ChatColor.GRAY + "Unlock rewards per LVL",
                "",
                ChatColor.GRAY + "Current LVL: " + ChatColor.RED + "N/A",
                ChatColor.GRAY + "Spider Slayer XP to LVL " + ChatColor.RED + "N/A" + ChatColor.GRAY + ":",
                ChatColor.WHITE + "--------------------- " + ChatColor.LIGHT_PURPLE + "0" + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + "N/A",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack drops = makeItem(Material.GOLD_NUGGET, ChatColor.GOLD + "Boss Drops", 1, 0,
                ChatColor.DARK_GRAY + "Tarantula Broodfather",
                "",
                ChatColor.GRAY + "Usually, the boss will drop",
                ChatColor.GREEN + "Tarantula Web " + ChatColor.GRAY + "which",
                ChatColor.GRAY + "are used for slayer crafts.",
                "",
                ChatColor.GRAY + "If you're lucky, you may get",
                ChatColor.GRAY + "one of the " + ChatColor.LIGHT_PURPLE + "8 " + ChatColor.GRAY + "possible",
                ChatColor.GRAY + "drops from this boss!",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack recipes = makeItem(Material.BOOK,  ChatColor.GREEN + "Slayer Recipes", 1, 0,
                ChatColor.DARK_GRAY + "Tarantula Broodfather",
                "",
                ChatColor.GRAY + "There are " + ChatColor.YELLOW + "14 " + ChatColor.GRAY + "recipes",
                ChatColor.GRAY + "related to the Spider boss.",
                "",
                ChatColor.GRAY + "Unlock recipes and collect",
                ChatColor.GRAY + "rare drops in order to",
                ChatColor.GRAY + "craft powerful items.",
                "",
                ChatColor.GRAY + "Unlocked: " + ChatColor.RED + "N/A",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack rngesusMeter = makeItem(Material.PAINTING, "§dRNGesus Meter", 1, 0,
                "§8Tarantula Broodfather",
                "",
                "§7Feeling §9unlucky§7? Slay",
                "§7bosses to fill the mefer",
                "§7amd guarantee an §dRNGesus",
                "§ddrop§7.",
                "",
                "§7Gaining an RNGesus drop",
                "§7will reset the meter.",
                "",
                "§dProgress:",
                "§f--------------------- §d0§5%");

        inventory.setItem(32, recipes);
        inventory.setItem(30, drops);
        inventory.setItem(28, progress);
        inventory.setItem(34, rngesusMeter);
    }
}
