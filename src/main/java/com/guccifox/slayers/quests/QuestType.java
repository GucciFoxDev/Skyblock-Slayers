package com.guccifox.slayers.quests;

import lombok.Getter;

public enum QuestType {
    /**
     * Zombie slayer stats
     */
    ZOMBIE_SLAYER_TIER_1(1, 1, "§aRevenant Horror I", 5),
    ZOMBIE_SLAYER_TIER_2(2, 2, "§eRevenant Horror II", 25),
    ZOMBIE_SLAYER_TIER_3(3, 3, "§cRevenant Horror III", 100),
    ZOMBIE_SLAYER_TIER_4(4, 4, "§4Revenant Horror IV", 500),
    ZOMBIE_SLAYER_TIER_5(5, 5, "§5Revenant Horror V", 1500),

    /**
     * Spider slayer stats
     */
    SPIDER_SLAYER_TIER_1(5, 1, "§aTarantula Broodfather I", 5),
    SPIDER_SLAYER_TIER_2(6, 2, "§eTarantula Broodfather II", 25),
    SPIDER_SLAYER_TIER_3(7, 3, "§cTarantula Broodfather III", 100),
    SPIDER_SLAYER_TIER_4(8, 4, "§4Tarantula Broodfather IV", 500),

    /**
     * Wolf slayer stats
     */
    WOLF_SLAYER_TIER_1(9, 1, "§aSven Packmaster I", 5),
    WOLF_SLAYER_TIER_2(10, 2, "§eSven Packmaster II", 25),
    WOLF_SLAYER_TIER_3(11, 3, "§cSven Packmaster III", 100),
    WOLF_SLAYER_TIER_4(12, 4, "§4Sven Packmaster IV", 500),

    /**
     * Enderman slayer stats
     */
    ENDERMAN_SLAYER_TIER_1(13, 1,"§aVoidgloom Seraph I", 5),
    ENDERMAN_SLAYER_TIER_2(14, 2,"§eVoidgloom Seraph II", 25),
    ENDERMAN_SLAYER_TIER_3(15, 3,"§cVoidgloom Seraph III", 100),
    ENDERMAN_SLAYER_TIER_4(16, 4,"§4Voidgloom Seraph IV", 500),

    /**
     * Blaze slayer stats
     */
    BLAZE_SLAYER_TIER_1(17, 1, "§aInferno Demonlord I", 5),
    BLAZE_SLAYER_TIER_2(18, 2, "§eInferno Demonlord II", 25),
    BLAZE_SLAYER_TIER_3(19, 3, "§cInferno Demonlord III", 100),
    BLAZE_SLAYER_TIER_4(20, 4, "§4Inferno Demonlord IV", 500);



    @Getter private final String displayname;
    @Getter private final int id;
    @Getter private final int tier;
    @Getter private final int xp;

    QuestType(int id, int tier, String displayname, int xp) {
        this.id = id;
        this.tier = tier;
        this.displayname = displayname;
        this.xp = xp;
    }

}
