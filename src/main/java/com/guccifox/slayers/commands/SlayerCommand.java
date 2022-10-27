package com.guccifox.slayers.commands;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.items.CustomItem;
import com.guccifox.slayers.items.ItemUtilities;
import com.guccifox.slayers.menus.ItemsMenu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.menus.SlayerShopMenu;
import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class SlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (s.equalsIgnoreCase("slayer")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.GREEN + "Success!");
                return true;
            }
            if (args[0].equalsIgnoreCase("menu")) {
                player.sendMessage(ChatColor.RED + "This command is not supported anymore. Use /cb ID to open the menu (with a valid id)");
            }
            if (args[0].equalsIgnoreCase("myquest")) {
                player.sendMessage(ChatColor.RED + "This command is not supported anymore.");
            }
            if (args[0].equalsIgnoreCase("spawnboss")) {
                if (player.hasPermission("slayers.admin")) {
                    player.sendMessage("§aSuccess!");
                    ZombieSlayerBoss.spawnZombieSlayerBoss(ZombieSlayerBoss.valueOf(args[1]), player.getLocation(), player);
                } else {
                    player.sendMessage("§cYou cannot do this!");
                }
            }
            if (args[0].equalsIgnoreCase("shop")) {
                new SlayerShopMenu(new PlayerMenuUtility(player)).open();
            }
            if (args[0].equalsIgnoreCase("item")) {
                if (player.hasPermission("slayers.admin")) {
                    give(commandSender, args);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have the permission to use this!");
                }
            }
            if (args[0].equalsIgnoreCase("olditemsmenu")) {
                if (player.hasPermission("slayers.admin")) {
                    new ItemsMenu(new PlayerMenuUtility(player)).open();
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have the permission to use this!");
                }
            }
        }
        return false;
    }

    private void give(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            ItemUtilities.warnPlayer(sender, Collections.singletonList("Only Players"));
            return;
        }
        Player player = (Player) sender;
        int stack = 1;
        if (args.length > 2)
            stack = Integer.parseInt(args[2]);
        ItemStack itemStack = CustomItem.fromString(Slayers.getPlugin(), args[1].toLowerCase(), stack);
        if (itemStack == null) {
            ItemUtilities.warnPlayer(sender, Collections.singletonList("Invalid item!"));
            return;
        }
        player.getInventory().addItem(itemStack);
        player.sendMessage(ChatColor.GREEN + "Given " + player.getName() + " item " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + ".");
    }
}
