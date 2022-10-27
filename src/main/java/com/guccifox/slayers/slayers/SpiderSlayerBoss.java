package com.guccifox.slayers.slayers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum SpiderSlayerBoss {

    SPIDER_SLAYER_TIER_1(5, 1),
    SPIDER_SLAYER_TIER_2(6, 2),
    SPIDER_SLAYER_TIER_3(7, 3),
    SPIDER_SLAYER_TIER_4(8, 4);

    public static HashMap<UUID, Entity> bossMap = new HashMap<>();
    public static Map<Entity, Double> bossHealth = new HashMap<>();

    private final int id;
    private final int tier;

    SpiderSlayerBoss(int id, int tier) {
        this.id = id;
        this.tier = tier;
    }

    public static void spawnSpiderSlayerBoss(SpiderSlayerBoss bossType, Location loc, Player player) {
        if(bossType.equals(SpiderSlayerBoss.SPIDER_SLAYER_TIER_1)) {

        } else if (bossType.equals(SpiderSlayerBoss.SPIDER_SLAYER_TIER_2)) {

        } else if(bossType.equals(SpiderSlayerBoss.SPIDER_SLAYER_TIER_3)) {

        } else if(bossType.equals(SpiderSlayerBoss.SPIDER_SLAYER_TIER_4)) {

        }
    }
}
