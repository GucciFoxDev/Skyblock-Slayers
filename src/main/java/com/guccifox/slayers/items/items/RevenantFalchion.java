package com.guccifox.slayers.items.items;

import com.guccifox.slayers.enums.ItemType;
import com.guccifox.slayers.enums.Rarity;
import com.guccifox.slayers.items.CustomItem;
import com.guccifox.slayers.items.ItemAbility;
import com.guccifox.slayers.listeners.slayerListeners.EntityDamageByEntity;
import com.guccifox.slayers.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RevenantFalchion extends CustomItem {
    public RevenantFalchion(int id, Rarity rarity, String name, Material material, int durability, boolean stackable, boolean oneTimeUse, boolean hasActive, List<ItemAbility> abilities, int manaCost, boolean reforgeable, ItemType itemType, boolean glowing) {
        super(id, rarity, name, material, durability, stackable, oneTimeUse, hasActive, abilities, manaCost, reforgeable, itemType, glowing);
    }
    public static boolean crit;

    public static boolean getCrit() {
        return crit;
    }

    @Override
    public void onItemStackCreate(ItemStack paramItemStack) {
        ItemMeta meta = paramItemStack.getItemMeta();
        meta.spigot().setUnbreakable(true);
        paramItemStack.setItemMeta(meta);
    }

    @Override
    public void getSpecificLorePrefix(List<String> lore, ItemStack paramItemStack) {
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+110");
        lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+60");
        lore.add(ChatColor.GRAY + "");
        lore.add(ChatColor.GRAY + "Intelligence: " + ChatColor.GREEN + "+100");
        lore.add(ChatColor.GRAY + "");
        lore.add(ChatColor.GRAY + "Deals " + ChatColor.GREEN + "+150% " + ChatColor.GRAY + "damage to");
        lore.add(ChatColor.GRAY + "Zombies.");
    }

    @Override
    public void getSpecificLoreSuffix(List<String> paramList, ItemStack paramItemStack) {

    }

    @Override
    public void leftClickAirAction(Player paramPlayer, ItemStack paramItemStack) {

    }

    @Override
    public void leftClickBlockAction(Player paramPlayer, PlayerInteractEvent paramPlayerInteractEvent, Block paramBlock, ItemStack paramItemStack) {

    }

    @Override
    public void rightClickAirAction(Player paramPlayer, PlayerInteractEvent event, ItemStack paramItemStack) {
        event.setCancelled(true);
    }

    @Override
    public void rightClickBlockAction(Player paramPlayer, PlayerInteractEvent event, Block paramBlock, ItemStack paramItemStack) {
        event.setCancelled(true);
    }

    @Override
    public void shiftLeftClickAirAction(Player paramPlayer, ItemStack paramItemStack) {

    }

    @Override
    public void shiftLeftClickBlockAction(Player paramPlayer, PlayerInteractEvent paramPlayerInteractEvent, Block paramBlock, ItemStack paramItemStack) {

    }

    @Override
    public void shiftRightClickAirAction(Player paramPlayer, PlayerInteractEvent event, ItemStack paramItemStack) {

    }

    @Override
    public void shiftRightClickBlockAction(Player paramPlayer, PlayerInteractEvent paramPlayerInteractEvent, Block paramBlock, ItemStack paramItemStack) {

    }

    @Override
    public void middleClickAction(Player paramPlayer, ItemStack paramItemStack) {

    }

    @Override
    public void hitEntityAction(Player player, EntityDamageByEntityEvent event, Entity entity, ItemStack stack) {
        float damage = (5 + 110 + (110/5)) * (1+ 110/100) * (1 + 320/ Utilities.getRandomInrange(120, 530)) * 2;

        if(event.getEntity().getType().toString().contains("ZOMBIE")) {
            damage += damage/2;
            event.setDamage(damage);
            EntityDamageByEntity e1 = new EntityDamageByEntity();
            e1.damage = damage;

            return;
        }

        event.setDamage(damage);
        EntityDamageByEntity e1 = new EntityDamageByEntity();
        e1.damage = damage;
    }

    @Override
    public void breakBlockAction(Player paramPlayer, BlockBreakEvent paramBlockBreakEvent, Block paramBlock, ItemStack paramItemStack) {

    }

    @Override
    public void clickedInInventoryAction(Player paramPlayer, InventoryClickEvent paramInventoryClickEvent) {

    }

    @Override
    public void activeEffect(Player paramPlayer, ItemStack paramItemStack) {

    }
}
