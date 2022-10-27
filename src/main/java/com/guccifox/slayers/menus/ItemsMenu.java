package com.guccifox.slayers.menus;

import com.guccifox.slayers.menus.handlers.Menu;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ItemsMenu extends Menu {
    public ItemsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }
    private ItemStack maddoxBatphone;
    public void regisyerItems() {
        maddoxBatphone = makeCustomSkullItem("http://textures.minecraft.net/texture/9336d7cc95cbf6689f5e8c954294ec8d1efc494a4031325bb427bc81d56a484d", "§aMaddox Batphone", 1,
                "§6Item Ability: Whassup? §e§lRIGHT CLICK",
                "§7Lets you call §5Maddox§7, when",
                "§7he's not busy.",
                "",
                "§a§lUNCOMMON");
    }

    @Override
    public String getTitle() {
        return "Select an Item";
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
            case "§6Hyperion":
                ItemStack hyperion = makeItem(Material.IRON_SWORD, "§6Hyperion", 1, 0,
                        "§7Gear Score: §d673",
                        "§7Damage: §c+293",
                        "§7Strength: §c+150",
                        "",
                        "§7Intelligence: §a400",
                        "§7Ferocity: §a+30",
                        "",
                        "§7Deals +§a50% §7damage to",
                        "§7Withers. Grants §c+1 ❁ Damage",
                        "§7and §a+2 §b✎ Intelligence",
                        "§7per §cCatacombs §7level.",
                        "",
                        "§7Your Catacombs level: §4N/A",
                        "",
                        "§eRight-Click to use your class ability!",
                        "",
                        "§8This item can be reforged!",
                        "§6§lLEGENDARY DUNGEON SWORD");
                player.getInventory().addItem(hyperion);
                break;
            case "§aMaddox Batphone": {
                regisyerItems();
                player.getInventory().addItem(maddoxBatphone);
            }
            case "§aSearch items":
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "This feature is temporarily disabled.");
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 10F, 0);
                break;
            case "§cClose":
                player.closeInventory();
                break;
        }
    }

    @Override
    public void setItems() {
        fillBottom();
        ItemStack close = makeItem(Material.BARRIER, "§cClose", 1, 0, "§7Close the menu.");
        inventory.setItem(49, close);
        ItemStack search = makeItem(Material.SIGN, "§aSearch items", 1, 0, "§7Find the item of", "§7your choice by", "§7searching!", "", "§cFeature Unavailable.");
        inventory.setItem(50, search);



        ItemStack hyperion = makeItem(Material.IRON_SWORD, "§6Hyperion", 1, 0,
                "§7Gear Score: §d673",
                "§7Damage: §c+293",
                "§7Strength: §c+150",
                "",
                "§7Intelligence: §a400",
                "§7Ferocity: §a+30",
                "",
                "§7Deals +§a50% §7damage to",
                "§7Withers. Grants §c+1 ❁ Damage",
                "§7and §a+2 §b✎ Intelligence",
                "§7per §cCatacombs §7level.",
                "",
                "§7Your Catacombs level: §4N/A",
                "",
                "§eRight-Click to use your class ability!",
                "",
                "§8This item can be reforged!",
                "§6§lLEGENDARY DUNGEON SWORD");


        regisyerItems();
        inventory.addItem(hyperion, maddoxBatphone);
    }
}
