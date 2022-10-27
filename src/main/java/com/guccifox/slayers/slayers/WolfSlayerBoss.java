package com.guccifox.slayers.slayers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum WolfSlayerBoss {

    WOLF_SLAYER_TIER_1(9, 1),
    WOLF_SLAYER_TIER_2(10, 2),
    WOLF_SLAYER_TIER_3(11, 3),
    WOLF_SLAYER_TIER_4(12, 4);

    public static HashMap<UUID, Entity> bossMap = new HashMap<>();
    public static Map<Entity, Double> bossHealth = new HashMap<>();

    private final int id;
    private final int tier;

    WolfSlayerBoss(int id, int tier) {
        this.id = id;
        this.tier = tier;
    }

    public static void spawnWolfSlayerBoss(WolfSlayerBoss bossType, Location loc, Player player) {
        if(bossType.equals(WolfSlayerBoss.WOLF_SLAYER_TIER_1)) {

        } else if (bossType.equals(WolfSlayerBoss.WOLF_SLAYER_TIER_2)) {

        } else if(bossType.equals(WolfSlayerBoss.WOLF_SLAYER_TIER_3)) {

        } else if(bossType.equals(WolfSlayerBoss.WOLF_SLAYER_TIER_4)) {

        }
    }
}
