package com.guccifox.slayers.slayers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum EndermanSlayerBoss {

    ENDERMAN_SLAYER_TIER_1(13, 1),
    ENDERMAN_SLAYER_TIER_2(14, 2),
    ENDERMAN_SLAYER_TIER_3(15, 3),
    ENDERMAN_SLAYER_TIER_4(16, 4);

    public static HashMap<UUID, Entity> bossMap = new HashMap<>();
    public static Map<Entity, Double> bossHealth = new HashMap<>();

    private final int id;
    private final int tier;

    EndermanSlayerBoss(int id, int tier) {
        this.id = id;
        this.tier = tier;
    }

    public static void spawnEndermanSlayerBoss(EndermanSlayerBoss bossType, Location loc, Player player) {
        if(bossType.equals(EndermanSlayerBoss.ENDERMAN_SLAYER_TIER_1)) {

        } else if (bossType.equals(EndermanSlayerBoss.ENDERMAN_SLAYER_TIER_2)) {

        } else if(bossType.equals(EndermanSlayerBoss.ENDERMAN_SLAYER_TIER_3)) {

        } else if(bossType.equals(EndermanSlayerBoss.ENDERMAN_SLAYER_TIER_4)) {

        }
    }
}
