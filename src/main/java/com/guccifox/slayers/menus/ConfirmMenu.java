package com.guccifox.slayers.menus;

import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import com.guccifox.slayers.menus.handlers.Menu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.quests.QuestType;
import com.guccifox.slayers.Slayers;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ConfirmMenu extends Menu {
    private final String reason;
    public ConfirmMenu(PlayerMenuUtility playerMenuUtility, String reason) {
        super(playerMenuUtility);
        this.reason = reason;
    }

    @Override
    public String getTitle() {
        return "Confirm";
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public void hadleMenu(InventoryClickEvent event) {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        new BukkitRunnable() {

            @Override
            public void run() {
                switch (event.getSlot()) {
                    case 11: {
                        if (reason.equalsIgnoreCase("cancel_quest")) {
                            Quest.cancelQuest(player);
                            if (ZombieSlayerBoss.bossMap.containsKey(player.getUniqueId())) {
                                ZombieSlayerBoss.bossMap.get(player.getUniqueId()).remove();
                            }
                            player.sendMessage("§eYour slayer quest was cancelled.");
                            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 10F, 1.5f);
                            player.closeInventory();
                            break;
                        }

                        if (reason.equalsIgnoreCase("start_quest_zombie_1")) {
                            player.closeInventory();
                            Quest.startQuest(player, QuestType.ZOMBIE_SLAYER_TIER_1);
                            player.sendMessage("§5§l  SLAYER QUEST STARTED!");
                            player.sendMessage("§5§l  » §7Slay §c100 Combat XP §7worth of Zombies.");
                            player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10F, 2);
                            break;

                        }

                        if (reason.equalsIgnoreCase("start_quest_zombie_2")) {
                            player.closeInventory();
                            Quest.startQuest(player, QuestType.ZOMBIE_SLAYER_TIER_2);
                            player.sendMessage("§5§l  SLAYER QUEST STARTED!");
                            player.sendMessage("§5§l  » §7Slay §c440 Combat XP §7worth of Zombies.");
                            player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10F, 2);
                            break;

                        }

                        if (reason.equalsIgnoreCase("start_quest_zombie_3")) {
                            player.closeInventory();
                            Quest.startQuest(player, QuestType.ZOMBIE_SLAYER_TIER_3);
                            player.sendMessage("§5§l  SLAYER QUEST STARTED!");
                            player.sendMessage("§5§l  » §7Slay §c670 Combat XP §7worth of Zombies.");
                            player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10F, 2);
                            break;

                        }

                        if (reason.equalsIgnoreCase("start_quest_zombie_4")) {
                            player.closeInventory();
                            Quest.startQuest(player, QuestType.ZOMBIE_SLAYER_TIER_4);
                            player.sendMessage("§5§l  SLAYER QUEST STARTED!");
                            player.sendMessage("§5§l  » §7Slay §c1440 Combat XP §7worth of Zombies.");
                            player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10F, 2);
                            break;
                        }

                        if (reason.equalsIgnoreCase("start_quest_zombie_5")) {
                            player.closeInventory();
                            Quest.startQuest(player, QuestType.ZOMBIE_SLAYER_TIER_5);
                            player.sendMessage("§5§l  SLAYER QUEST STARTED!");
                            player.sendMessage("§5§l  » §7Slay §c6000 Combat XP §7worth of Zombies.");
                            player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10F, 2);
                            break;
                        }

                        break;
                    }
                    case 15:
                        player.closeInventory();
                }
            }
        }.runTaskLater(Slayers.getPlugin(), 3);
    }

    @Override
    public void setItems() {
        ItemStack confirm = makeItem(Material.STAINED_CLAY, "§aConfirm", 1, 5);
        inventory.setItem(11, confirm);

        ItemStack cancel = makeItem(Material.STAINED_CLAY, "§cCancel", 1, 14);
        inventory.setItem(15, cancel);
    }
}
