package com.guccifox.slayers.slayers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum BlazeSlayerBoss {

    BLAZE_SLAYER_TIER_1(17, 1),
    BLAZE_SLAYER_TIER_2(18, 2),
    BLAZE_SLAYER_TIER_3(19, 3),
    BLAZE_SLAYER_TIER_4(20, 4);

    public static HashMap<UUID, Entity> bossMap = new HashMap<>();
    public static Map<Entity, Double> bossHealth = new HashMap<>();

    private final int id;
    private final int tier;

    BlazeSlayerBoss(int id, int tier) {
        this.id = id;
        this.tier = tier;
    }

    public static void spawnBlazeSlayerBoss(BlazeSlayerBoss bossType, Location loc, Player player) {
        if(bossType.equals(BlazeSlayerBoss.BLAZE_SLAYER_TIER_1)) {

        } else if (bossType.equals(BlazeSlayerBoss.BLAZE_SLAYER_TIER_2)) {

        } else if(bossType.equals(BlazeSlayerBoss.BLAZE_SLAYER_TIER_3)) {

        } else if(bossType.equals(BlazeSlayerBoss.BLAZE_SLAYER_TIER_4)) {

        }
    }
}
