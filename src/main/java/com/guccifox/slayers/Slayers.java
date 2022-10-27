package com.guccifox.slayers;

import com.guccifox.slayers.commands.*;
import com.guccifox.slayers.enums.AbilityType;
import com.guccifox.slayers.enums.ItemType;
import com.guccifox.slayers.enums.Rarity;
import com.guccifox.slayers.items.ItemAbility;
import com.guccifox.slayers.items.constructors.SBItems;
import com.guccifox.slayers.items.items.*;
import com.guccifox.slayers.items.items.drops.revenant.*;
import com.guccifox.slayers.leveling.*;
import com.guccifox.slayers.listeners.*;
import com.guccifox.slayers.listeners.slayerListeners.EntityDamageByEntity;
import com.guccifox.slayers.listeners.slayerListeners.EntityDeathEvent;
import com.guccifox.slayers.menus.handlers.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

/**
 * All rights to the Hypixel Network for the plugin idea.
 * This is only a re-creation.
 */

// TODO: CLEAN UP DATA SAVING CODE

public class Slayers extends JavaPlugin {

    // Create menu utility hashmap
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    // Slayer hashmaps
    public HashMap<UUID, ZombieSlayerLevelManager> ZombieSlayerLevelManagerHashMap;
    public HashMap<UUID, SpiderSlayerLevelManager> SpiderSlayerLevelManagerHashMap;
    public HashMap<UUID, WolfSlayerLevelManager> WolfSlayerLevelManagerHashMap;
    public HashMap<UUID, EndermanSlayerLevelManager> EndermanSlayerLevelManagerHashMap;
    public HashMap<UUID, BlazeSlayerLevelManager> BlazeSlayerLevelManagerHashMap;

    // Define plugin
    public static Slayers plugin;

    public static Slayers getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        // Setup hashmaps
        this.ZombieSlayerLevelManagerHashMap = new HashMap<>();
        this.SpiderSlayerLevelManagerHashMap = new HashMap<>();
        this.WolfSlayerLevelManagerHashMap = new HashMap<>();
        this.EndermanSlayerLevelManagerHashMap = new HashMap<>();
        this.BlazeSlayerLevelManagerHashMap = new HashMap<>();
        // Register & setup stuff
        registerCommands();
        registerItems();
        registerListeners();
        saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Slayers enabled. §ev1.2");
    }

    @Override
    public void onDisable() {
        createPlayerDataFile();
        // Clear hashmaps
        this.ZombieSlayerLevelManagerHashMap.clear();
        this.SpiderSlayerLevelManagerHashMap.clear();
        this.WolfSlayerLevelManagerHashMap.clear();
        this.EndermanSlayerLevelManagerHashMap.clear();
        this.BlazeSlayerLevelManagerHashMap.clear();

        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Slayers disabled.");
    }

    // Register commands
    private void registerCommands() {
        this.getCommand("slayer").setExecutor(new SlayerCommand());
        this.getCommand("batphone").setExecutor(new BatphoneCommand());
        this.getCommand("unbreakable").setExecutor(new UnbreakableCommand());
    }

    // Register Listeners
    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerUseCustomItem(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntity(), this);
    }

    // Register Items
    private void registerItems() {

        // Revenant slayer
        SBItems.putItem("REVENANT_FLESH", new RevenantFlesh(8, Rarity.UNCOMMON, "Revenant Flesh", Material.ROTTEN_FLESH, 0, true, false, false, null, 0, false, ItemType.ITEM, true));
        SBItems.putItem("FOUL_FLESH", new FoulFlesh(9, Rarity.RARE, "Foul Flesh", Material.COAL, 0, true, false, false, null, 0, false, ItemType.ITEM, false));
        SBItems.putItem("BEHEADED_HORROR", new BeheadedHorror(10, Rarity.EPIC, "Beheaded Horror", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/dbad99ed3c820b7978190ad08a934a68dfa90d9986825da1c97f6f21f49ad626", false));
        SBItems.putItem("PESTILENCE_RUNE", new PestilenceRune(11, Rarity.RARE, "§2◆ Pestilence Rune I", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.COSMETIC, "http://textures.minecraft.net/texture/a8c4811395fbf7f620f05cc3175cef1515aaf775ba04a01045027f0693a90147", false));
        SBItems.putItem("REVENANT_CATALYST", new RevenantCatalyst(12, Rarity.EPIC, "Revenant Catalyst", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/b88cfafa5f03f8aef042a143799e964342df76b7c1eb461f618e398f84a99a63", false));
        SBItems.putItem("REVENANT_VISCERA", new RevenantViscera(13, Rarity.RARE, "Revenant Viscera", Material.GRILLED_PORK, 0, true, false, false, null, 0, false, ItemType.ITEM, true));
        SBItems.putItem("SCYTHE_BLADE", new ScytheBlade(14, Rarity.LEGENDARY, "Scythe Blade", Material.DIAMOND, 0, true, false, false, null, 0, false, ItemType.ITEM, true));
        SBItems.putItem("SHARD_OF_THE_SHREDDED", new ShardOfTheShredded(15, Rarity.LEGENDARY, "Shard of the Shredded", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/b88cfafa5f03f8aef042a143799e964342df76b7c1eb461f618e398f84a99a63", false));
        SBItems.putItem("SMITE_SEVEN_BOOK", new SmiteSevenBook(16, Rarity.EPIC, "Enchanted Book", Material.ENCHANTED_BOOK, 0, true, false, false, null, 0, false, ItemType.ITEM, true));
        SBItems.putItem("SMITE_SIX_BOOK", new SmiteSixBook(17, Rarity.RARE, "Enchanted Book", Material.ENCHANTED_BOOK, 0, true, false, false, null, 0, false, ItemType.ITEM, true));
        SBItems.putItem("SNAKE_RUNE", new SnakeRune(18, Rarity.LEGENDARY, "§a◆ Snake Rune I", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.COSMETIC, "http://textures.minecraft.net/texture/2c4a65c689b2d36409100a60c2ab8d3d0a67ce94eea3c1f7ac974fd893568b5d", false));
        SBItems.putItem("UNDEAD_CATALYST", new UndeadCatalyst(19, Rarity.RARE, "Undead Catalyst", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/80625369b0a7b052632db6b926a87670219539922836ac5940be26d34bf14e10", false));
        SBItems.putItem("WARDEN_HEART", new WardenHeart(20, Rarity.LEGENDARY, "Warden Heart", Material.SKULL_ITEM, 3, false, false, true, null, 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/d45f4d139c9e89262ec06b27aaad73fa488ab49290d2ccd685a2554725373c9b", false));

        // Tarantula Slayer

        // Sven Slayer

        // Voidgloom Slayer

        // Inferno Slayer
        SBItems.putItem("MADDOX_BATPHONE", new MaddoxBatphone(1, Rarity.UNCOMMON, "Maddox Batphone", Material.SKULL_ITEM , 3, true, false, false, Collections.singletonList(new ItemAbility("Whassup?", AbilityType.RIGHT_CLICK, "§7Lets you call §5Maddox§7, when\nhe is not busy.\n")), 0, false, ItemType.ITEM, "http://textures.minecraft.net/texture/9336d7cc95cbf6689f5e8c954294ec8d1efc494a4031325bb427bc81d56a484d", false));
        SBItems.putItem("WAND_OF_HEALING", new WandOfHealing(2, Rarity.UNCOMMON, "Wand of Healing", Material.STICK, 0, false, false, false, Collections.singletonList(new ItemAbility("Small Heal", AbilityType.RIGHT_CLICK, "§7Heal §c20❤§7/s for 7s.\n§8Wand heals don't stack.", 1)), 60, false, ItemType.WAND, true));
        SBItems.putItem("REVENANT_FALCHION", new RevenantFalchion(3, Rarity.RARE, "Revenant Falchion", Material.DIAMOND_SWORD, 0, false, false, false, null, 0, true, ItemType.SWORD, false));
        SBItems.putItem("WAND_OF_MENDING", new WandOfMending(4, Rarity.RARE, "Wand of Mending", Material.STICK, 0, false, false, false, Collections.singletonList(new ItemAbility("Medium Heal", AbilityType.RIGHT_CLICK, "§7Heal §c90❤§7/s for 3s.\n§8Wand heals don't stack.", 1)), 80, false, ItemType.WAND, true));
        SBItems.putItem("WAND_OF_RESTORATION", new WandOfRestoration(5, Rarity.EPIC, "Wand of Restoration", Material.STICK, 0, false, false, false, Collections.singletonList(new ItemAbility("Big Heal", AbilityType.RIGHT_CLICK, "§7Heal §c120❤§7/s for 3s.\n§8Wand heals don't stack.", 1)), 100, false, ItemType.WAND, true));
        SBItems.putItem("ZOMBIE_RING", new ZombieRing(6, Rarity.UNCOMMON, "Zombie Ring", Material.SKULL_ITEM, 3, false, false, true, null, 0, true, ItemType.ACCESSORY, "http://textures.minecraft.net/texture/177c9c638bf3dcda348edea44e9a3db4abc1e239558661611f80c110472ad", false));
        SBItems.putItem("REAPER_FALCHION", new ReaperFalchion(7, Rarity.EPIC, "Reaper Falchion", Material.DIAMOND_SWORD, 0, false, false, false, null, 0, true, ItemType.SWORD, false));
    }

    private void createPlayerDataFile() {
        File playerData = new File("plugins/Hypixel_Slayers/playerData");
        if (!playerData.exists()) {
            playerData.mkdir();
        }
    }

    private static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(player))) {

            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(player);
        }
    }
}
