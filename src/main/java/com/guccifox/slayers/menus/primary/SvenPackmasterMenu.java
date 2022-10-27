package com.guccifox.slayers.menus.primary;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.menus.ConfirmMenu;
import com.guccifox.slayers.menus.handlers.Menu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.menus.primary.SlayersMenu;
import com.guccifox.slayers.quests.Quest;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SvenPackmasterMenu extends Menu {
    public SvenPackmasterMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getTitle() {
        return "Sven Packmaster";
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
            case "§aSven Packmaster I":
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_wolf_1").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);
                }
                break;
            case "§eSven Packmaster II": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_wolf_2").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);

                }
                break;
            }

            case "§cSven Packmaster III": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_wolf_3").open();
                        }
                    }.runTaskLater(Slayers.getPlugin(), 3);

                }
                break;
            }
            case "§4Sven Packmaster IV": {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "You are already running a quest!");
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new ConfirmMenu(new PlayerMenuUtility(player), "start_quest_wolf_4").open();
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
        ItemStack tier1 = makeItem(Material.MUTTON, "§aSven Packmaster I", 1, 0,
                "§8Beginner",
                "",
                "§7Health: §c2,000❤",
                "§7Damage: §c60 §7per second",
                "",
                "§aAgile",
                "§7The wolf is small and fast, making",
                "§7it hard to hit.",
                "",
                "§7Reward: §d6 Wolf Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §61,000 coins",
                "",
                "§eClick to slay!");
        inventory.setItem(11, tier1);

        ItemStack tier2 = makeItem(Material.MUTTON, "§eSven Packmaster II", 2, 0,
                "§8Strong",
                "",
                "§7Health: §c40,000❤",
                "§7Damage: §c80 §7per second",
                "§7True damage: §f10 §7per second",
                "",
                "§aAgile",
                "§7The wolf is small and fast, making",
                "§7it hard to hit.",
                "",
                "§fTrue Damage",
                "§7Ignores your defence. Very painful.",
                "",
                "§7Reward: §d31 Wolf Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §63,750 coins",
                "",
                "§eClick to slay!");
        inventory.setItem(12, tier2);

        ItemStack tier3 = makeItem(Material.MUTTON, "§cSven Packmaster III", 3, 0,
                "§8Challenging",
                "",
                "§7Health: §c750,000❤",
                "§7Damage: §c180 §7per second",
                "§7True damage: §f50 §7per second",
                "",
                "§aAgile",
                "§7The wolf is small and fast, making",
                "§7it hard to hit.",
                "",
                "§fTrue Damage",
                "§7Ignores your defence. Very painful.",
                "",
                "§bCall the pups!",
                "§7At 50% health, calls its deadly pack",
                "§7of pups.",
                "",
                "§7Reward: §d125 Wolf Slayer XP",
                " §8+ Boss Drops",
                "",
                "§7Cost to start: §610,000 coins",
                "",
                "§eClick to slay!");

        ItemStack tier4 = makeItem(Material.MUTTON, "§4Sven Packmaster IV", 4, 0,
                "§8Truly Painful",
                "",
                "§7Health: §c2,000,000❤",
                "§7Damage: §c440 §7per second",
                "§7True damage: §f200 §7per second",
                "",
                "§aAgile",
                "§7The wolf is small and fast, making",
                "§7it hard to hit.",
                "",
                "§fTrue Damage",
                "§7Ignores your defence. Very painful.",
                "",
                "§bCall the pups!",
                "§7At 50% health, calls its deadly pack",
                "§7of pups.",
                "",
                "§7Reward: §d625 Wolf Slayer XP",
                "§8 + Boss Drops",
                "",
                "§7Cost to start: §625,000 coins",
                "",
                "§eClick to slay!");

        ItemStack comingSoon = makeItem(Material.COAL_BLOCK, "§5Sven Packmaster", 1, 0,
                "§7This unimaginably difficult",
                "§7boss tier will release at a",
                "§7later date.");

        inventory.setItem(13, tier3);
        inventory.setItem(14, tier4);
        inventory.setItem(15, comingSoon);

        ItemStack back = makeItem(Material.ARROW, "§aGo back", 1, 0, "§7To Slayer");
        inventory.setItem(49, back);

        ItemStack progress = makeItem(Material.GOLD_BLOCK, "§5Boss Leveling Rewards", 1, 0,
                ChatColor.DARK_GRAY + "Wolf Slayer LVL",
                "",
                ChatColor.DARK_PURPLE + "1. " + ChatColor.GRAY + "Kill boss to get XP",
                ChatColor.DARK_PURPLE + "2. " + ChatColor.GRAY + "Gain LVL from XP",
                ChatColor.DARK_PURPLE + "3. " + ChatColor.GRAY + "Unlock rewards per LVL",
                "",
                ChatColor.GRAY + "Current LVL: " + ChatColor.RED + "N/A",
                ChatColor.GRAY + "Wolf Slayer XP to LVL " + ChatColor.RED + "N/A" + ChatColor.GRAY + ":",
                ChatColor.WHITE + "--------------------- " + ChatColor.LIGHT_PURPLE + "0" + ChatColor.DARK_PURPLE + "/" + ChatColor.RED + "N/A",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack drops = makeItem(Material.GOLD_NUGGET, ChatColor.GOLD + "Boss Drops", 1, 0,
                ChatColor.DARK_GRAY + "Sven Packmaster",
                "",
                ChatColor.GRAY + "Usually, the boss will drop",
                ChatColor.GREEN + "Wolf Tooth " + ChatColor.GRAY + "which",
                ChatColor.GRAY + "are used for slayer crafts.",
                "",
                ChatColor.GRAY + "If you're lucky, you may get",
                ChatColor.GRAY + "one of the " + ChatColor.LIGHT_PURPLE + "9 " + ChatColor.GRAY + "possible",
                ChatColor.GRAY + "drops from this boss!",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack recipes = makeItem(Material.BOOK,  ChatColor.GREEN + "Slayer Recipes", 1, 0,
                ChatColor.DARK_GRAY + "Sven Packmaster",
                "",
                ChatColor.GRAY + "There are " + ChatColor.YELLOW + "22 " + ChatColor.GRAY + "recipes",
                ChatColor.GRAY + "related to the Wolf boss.",
                "",
                ChatColor.GRAY + "Unlock recipes and collect",
                ChatColor.GRAY + "rare drops in order to",
                ChatColor.GRAY + "craft powerful items.",
                "",
                ChatColor.GRAY + "Unlocked: " + ChatColor.RED + "N/A",
                "",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");

        ItemStack rngesusMeter = makeItem(Material.PAINTING, "§dRNGesus Meter", 1, 0,
                "§8Sven Packmaster",
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
