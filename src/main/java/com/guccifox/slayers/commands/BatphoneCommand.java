package com.guccifox.slayers.commands;

import com.guccifox.slayers.items.constructors.SBItems;
import com.guccifox.slayers.quests.Quest;
import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import com.guccifox.slayers.menus.QuestMenu;
import com.guccifox.slayers.menus.primary.SlayersMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BatphoneCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 0 ) {
                player.sendMessage(ChatColor.RED + "Missing arguments!");
                return true;
            }
            if (args[0].equals(Slayers.getPlugin().getConfig().getString("permanent-id"))) {
                if (Quest.quest.containsKey(player.getUniqueId())) {
                    new QuestMenu(new PlayerMenuUtility(player), false).open();
                } else {
                    new SlayersMenu(new PlayerMenuUtility(player)).open();
                }
                return true;
            }

            if (SBItems.id.containsKey(player.getUniqueId())) {
                if (args[0].equals(SBItems.id.get(player.getUniqueId()))) {
                    if (Quest.quest.containsKey(player.getUniqueId())) {
                        new QuestMenu(new PlayerMenuUtility(player), true).open();
                    } else {
                        new SlayersMenu(new PlayerMenuUtility(player)).open();
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "This action has expired!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "This action has expired!");
            }
        }
        return false;
    }
}
