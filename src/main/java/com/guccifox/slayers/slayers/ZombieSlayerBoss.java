package com.guccifox.slayers.slayers;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.utilities.Utilities;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityTypes;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.lang.reflect.Field;
import java.util.*;

public enum ZombieSlayerBoss {
    ZOMBIE_SLAYER_TIER_1(1, 1),
    ZOMBIE_SLAYER_TIER_2(2, 2),
    ZOMBIE_SLAYER_TIER_3(3, 3),
    ZOMBIE_SLAYER_TIER_4(4, 4),
    ZOMBIE_SLAYER_TIER_5(5, 5);

    public static HashMap<UUID, Entity> bossMap = new HashMap<>();
    public static Map<Entity, Double> bossHealth = new HashMap<>();

    private final int id;
    private final int tier;

    ZombieSlayerBoss(int id, int tier) {
        this.id = id;
        this.tier = tier;
    }

    public static Map<Entity, ArmorStand> tag = new HashMap<>();

    public static void playBossSpawnEffect(Location loc) {
        for(int i = 0; i < 50; ++i) {
            playEffectWithDelay(loc.add(0, 1, 0), i);
            playSoundWithDelay(loc, i);
        }
    }

    private static void playEffectWithDelay(Location loc, long delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loc.getWorld().playEffect(loc, Effect.POTION_SWIRL, 20, 20);
                loc.getWorld().playEffect(loc, Effect.MAGIC_CRIT, 20, 20);
            }
        }.runTaskLater(Slayers.getPlugin(), delay);
    }

    private static void playSoundWithDelay(Location loc, long delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loc.getWorld().playSound(loc, Sound.WITHER_SHOOT, 1f, 1.5f);
            }
        }.runTaskLater(Slayers.getPlugin(), delay);
    }

    public static void spawnZombieSlayerBoss(ZombieSlayerBoss bossType, Location loc, Player player) {
        ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta hoeMeta = hoe.getItemMeta();
        hoeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        hoe.setItemMeta(hoeMeta);
        if(bossType == null) return;
        if(bossType.equals(ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_1)) {
            Zombie boss1 = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            boss1.getEquipment().setHelmet(makeSkullItem("ZOMBIE_SLAYER_TIER_1", "Wishingbee16", 1));
            boss1.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            boss1.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            boss1.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            boss1.getEquipment().setItemInHand(hoe);
            boss1.setBaby(false);
            boss1.setMaxHealth(500);
            boss1.setHealth(500);
            boss1.setTarget(player);
            boss1.setVillager(false);
            boss1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 7), false);
            boss1.setVelocity(new Vector(0, 0.5, 0));
            boss1.setFallDistance(0);
            bossMap.put(player.getUniqueId(), boss1);
            bossHealth.put(boss1, 500d);

            ArmorStand name = (ArmorStand) player.getWorld().spawnEntity(boss1.getLocation().add(0, +1, 0), EntityType.ARMOR_STAND);
            name.setCustomNameVisible(true);
            name.setCustomName("§c☠ §bRevenant Horror §a" + boss1.getHealth() + "§7/§a" + boss1.getMaxHealth());
            name.setVisible(false);
            name.setGravity(false);
            NBTEntity nbtas = new NBTEntity(name);
            nbtas.setBoolean("Invulnerable", true);
            tag.put(boss1, name);

            int i = 1;
            i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if(tag.containsKey(boss1)) {
                        if(!(boss1.isDead())) {
                            Location l = boss1.getLocation().add(0, 0.3, 0);
                            name.setCustomName("§8[§7Lv10§8] §c☠ §bRevenant Horror §a" + Math.round(bossHealth.get(boss1)) + "§c ❤");
                            boss1.getWorld().playEffect(boss1.getLocation(), Effect.MAGIC_CRIT, 3);
                            name.teleport(l);
                            boss1.getWorld().playEffect(boss1.getLocation(), Effect.HEART, 2);
                        } else {
                            tag.remove(boss1);
                            name.remove();
                        }
                    }
                }
            }, 0L, 1L);
        }

        if (bossType == ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_2) {
            Zombie boss2 = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            boss2.getEquipment().setHelmet(makeSkullItem("ZOMBIE_SLAYER_TIER_2", "Wishingbee16", 1));
            boss2.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            boss2.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            boss2.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            boss2.getEquipment().setItemInHand(hoe);
            boss2.setBaby(false);
            boss2.setMaxHealth(20000);
            boss2.setHealth(20000);
            boss2.setTarget(player);
            boss2.setVillager(false);
            boss2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 7), false);
            boss2.setVelocity(new Vector(0, 0.5, 0));
            boss2.setFallDistance(0);
            bossMap.put(player.getUniqueId(), boss2);
            bossHealth.put(boss2, 20000d);

            ArmorStand name = (ArmorStand) player.getWorld().spawnEntity(boss2.getLocation().add(0, +1, 0), EntityType.ARMOR_STAND);
            name.setCustomNameVisible(true);
            name.setCustomName("§c☠ §bRevenant Horror §a" + boss2.getHealth() + "§7/§a" + boss2.getMaxHealth());
            name.setVisible(false);
            name.setGravity(false);
            NBTEntity nbtas = new NBTEntity(name);
            nbtas.setBoolean("Invulnerable", true);
            tag.put(boss2, name);

            int i = 1;
            i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (tag.containsKey(boss2)) {
                        if (!(boss2.isDead())) {
                            Location l = boss2.getLocation().add(0, 0.3, 0);
                            if (Math.round(boss2.getHealth()) < 1000) {
                                name.setCustomName("§8[§7Lv70§8] §c☠ §bRevenant Horror §a" + Math.round(bossHealth.get(boss2)) + "§c ❤");
                            } else if (boss2.getHealth() >= 1000) {
                                name.setCustomName("§8[§7Lv70§8] §c☠ §bRevenant Horror §a" + Utilities.formatValue(bossHealth.get(boss2)) + "§c ❤");
                            }
                            boss2.getWorld().playEffect(boss2.getLocation(), Effect.MAGIC_CRIT, 3);
                            name.teleport(l);
                            boss2.getWorld().playEffect(boss2.getLocation(), Effect.HEART, 2);
                        } else {
                            tag.remove(boss2);
                            name.remove();
                        }
                    }
                }
            }, 0L, 1L);
        }
        if (bossType == ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_3) {
            Zombie boss3 = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            boss3.getEquipment().setHelmet(makeSkullItem("ZOMBIE_SLAYER_TIER_3", "Wishingbee16", 1));
            boss3.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            boss3.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            boss3.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            boss3.getEquipment().setItemInHand(hoe);
            boss3.setBaby(false);
            boss3.setMaxHealth(400000);
            boss3.setHealth(400000);
            boss3.setTarget(player);
            boss3.setVillager(false);
            boss3.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 7), false);
            boss3.setVelocity(new Vector(0, 0.5, 0));
            boss3.setFallDistance(0);
            bossMap.put(player.getUniqueId(), boss3);
            bossHealth.put(boss3, 400000d);

            ArmorStand name = (ArmorStand) player.getWorld().spawnEntity(boss3.getLocation().add(0, +1, 0), EntityType.ARMOR_STAND);
            name.setCustomNameVisible(true);
            name.setCustomName("§c☠ §bRevenant Horror §a" + boss3.getHealth() + "§7/§a" + boss3.getMaxHealth());
            name.setVisible(false);
            name.setGravity(false);
            NBTEntity nbtas = new NBTEntity(name);
            nbtas.setBoolean("Invulnerable", true);
            tag.put(boss3, name);

            int i = 1;
            i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (tag.containsKey(boss3)) {
                        if (!(boss3.isDead())) {
                            Location l = boss3.getLocation().add(0, 0.3, 0);
                            if (Math.round(boss3.getHealth()) < 1000) {
                                name.setCustomName("§8[§7Lv310§8] §c☠ §bRevenant Horror §a" + Math.round(bossHealth.get(boss3)) + "§c ❤");
                            } else if (boss3.getHealth() >= 1000) {
                                name.setCustomName("§8[§7Lv310§8] §c☠ §bRevenant Horror §a" + Utilities.formatValue(bossHealth.get(boss3)) + "§c ❤");
                            }
                            boss3.getWorld().playEffect(boss3.getLocation(), Effect.MAGIC_CRIT, 3);
                            name.teleport(l);
                            boss3.getWorld().playEffect(boss3.getLocation(), Effect.HEART, 2);
                        } else {
                            tag.remove(boss3);
                            name.remove();
                        }
                    }
                }
            }, 0L, 1L);
        }

        if (bossType == ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_4) {
            Zombie boss4 = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            boss4.getEquipment().setHelmet(makeSkullItem("ZOMBIE_SLAYER_TIER_4", "Wishingbee16", 1));
            boss4.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            boss4.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            boss4.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            boss4.getEquipment().setItemInHand(hoe);
            boss4.setBaby(false);
            boss4.setMaxHealth(1500000);
            boss4.setHealth(1500000);
            boss4.setTarget(player);
            boss4.setVillager(false);
            boss4.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 7), false);
            boss4.setVelocity(new Vector(0, 0.5, 0));
            boss4.setFallDistance(0);
            bossMap.put(player.getUniqueId(), boss4);
            bossHealth.put(boss4, 1500000d);

            ArmorStand name = (ArmorStand) player.getWorld().spawnEntity(boss4.getLocation().add(0, +1, 0), EntityType.ARMOR_STAND);
            name.setCustomNameVisible(true);
            name.setCustomName("§c☠ §bRevenant Horror §a" + boss4.getHealth() + "§7/§a" + boss4.getMaxHealth());
            name.setVisible(false);
            name.setGravity(false);
            NBTEntity nbtas = new NBTEntity(name);
            nbtas.setBoolean("Invulnerable", true);
            tag.put(boss4, name);

            int i = 1;
            i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (tag.containsKey(boss4)) {
                        if (!(boss4.isDead())) {
                            Location l = boss4.getLocation().add(0, 0.3, 0);
                            if (Math.round(boss4.getHealth()) < 1000) {
                                name.setCustomName("§8[§7Lv601§8] §c☠ §bRevenant Horror §a" + Math.round(bossHealth.get(boss4)) + "§c ❤");
                            } else if (boss4.getHealth() >= 1000) {
                                name.setCustomName("§8[§7Lv601§8] §c☠ §bRevenant Horror §a" + Utilities.formatValue(bossHealth.get(boss4)) + "§c ❤");
                            }
                            boss4.getWorld().playEffect(boss4.getLocation(), Effect.MAGIC_CRIT, 3);
                            name.teleport(l);
                            boss4.getWorld().playEffect(boss4.getLocation(), Effect.HEART, 2);
                        } else {
                            tag.remove(boss4);
                            name.remove();
                        }
                    }
                }
            }, 0L, 1L);
        }

        if (bossType == ZombieSlayerBoss.ZOMBIE_SLAYER_TIER_5) {
            Zombie boss5 = (Zombie) player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            boss5.getEquipment().setHelmet(makeSkullItem("ZOMBIE_SLAYER_TIER_5", "Wishingbee16", 1));
            boss5.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            boss5.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            boss5.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            boss5.getEquipment().setItemInHand(hoe);
            boss5.setBaby(false);
            boss5.setMaxHealth(1.0E7);
            boss5.setHealth(1.0E7);
            boss5.setTarget(player);
            boss5.setVillager(false);
            boss5.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 7), false);
            boss5.setVelocity(new Vector(0, 0.5, 0));
            boss5.setFallDistance(0);
            bossMap.put(player.getUniqueId(), boss5);
            bossHealth.put(boss5, 10000000d);

            ArmorStand name = (ArmorStand) player.getWorld().spawnEntity(boss5.getLocation().add(0, +1, 0), EntityType.ARMOR_STAND);
            name.setCustomNameVisible(true);
            name.setCustomName("§c☠ §bRevenant Horror §a" + boss5.getHealth() + "§7/§a" + boss5.getMaxHealth());
            name.setVisible(false);
            name.setGravity(false);
            NBTEntity nbtas = new NBTEntity(name);
            nbtas.setBoolean("Invulnerable", true);
            tag.put(boss5, name);

            int i = 1;
            i = Bukkit.getScheduler().scheduleSyncRepeatingTask(Slayers.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    if (tag.containsKey(boss5)) {
                        if (!(boss5.isDead())) {
                            Location l = boss5.getLocation().add(0, 0.3, 0);
                            if (Math.round(boss5.getHealth()) < 1000) {
                                name.setCustomName("§8[§7Lv601§8] §c☠ §bRevenant Horror §a" + Math.round(bossHealth.get(boss5)) + "§c ❤");
                            } else if (boss5.getHealth() >= 1000) {
                                name.setCustomName("§8[§7Lv601§8] §c☠ §bRevenant Horror §a" + Utilities.formatValue(bossHealth.get(boss5)) + "§c ❤");
                            }
                            boss5.getWorld().playEffect(boss5.getLocation(), Effect.MAGIC_CRIT, 3);
                            name.teleport(l);
                            boss5.getWorld().playEffect(boss5.getLocation(), Effect.HEART, 2);
                        } else {
                            tag.remove(boss5);
                            name.remove();
                        }
                    }
                }
            }, 0L, 1L);
        }
    }

    public static ItemStack makeSkullItem(String displayname, String owner, int amount, String... lore) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, amount, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(owner);
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(displayname);
        item.setItemMeta(meta);

        return item;
    }
}
