package com.guccifox.slayers.quests;

import com.guccifox.slayers.listeners.slayerListeners.EntityDeathEvent;
import com.guccifox.slayers.slayers.ZombieSlayerBoss;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Quest {
    /**
     * Hashmaps for quests
     */
    public static HashMap<UUID, QuestType> quest = new HashMap<>();
    public static HashMap<UUID, Boolean> fightingBoss = new HashMap<>();
    public static HashMap<UUID, Boolean> questComplete = new HashMap<>();

    /**
     *
     * @param player the player whos quest you want to get
     * @return the players current active quest
     */
    public static HashMap<UUID, QuestType> getQuest(Player player) {
        return quest;
    }

    /**
     *
     * @param player the player who you want to start the quest for
     * @param type type of quest you want to start
     */
    public static void startQuest(Player player, QuestType type) {
        quest.put(player.getUniqueId(), type);
    }

    /**
     *
     * @param questType quest type you want to get the difficulty of
     * @return the difficulty of a slayer
     */
    public QuestDifficulty getDifficulty(QuestType questType) {
        if (questType.toString().contains("ZOMBIE_SLAYER"))
            return QuestDifficulty.EASY;
        if (questType.toString().contains("SPIDER_SLAYER"))
            return QuestDifficulty.MEDIUM;
        if (questType.toString().contains("WOLF_SLAYER"))
            return QuestDifficulty.HARD;
        if (questType.toString().contains("ENDERMAN_SLAYER"))
            return QuestDifficulty.HARD;
        if (questType.toString().contains("BLAZE_SLAYER"))
            return QuestDifficulty.HARD;

        return null;
    }

    /**
     *
     * @param player the player you want to check
     * @return the current type of slayer quest
     */
    public QuestType getType(Player player) {
        if (quest.containsKey(player.getUniqueId())) {
            switch (quest.get(player.getUniqueId())) {
                case ZOMBIE_SLAYER_TIER_1:
                    return QuestType.ZOMBIE_SLAYER_TIER_1;
                case ZOMBIE_SLAYER_TIER_2:
                    return QuestType.ZOMBIE_SLAYER_TIER_2;
                case ZOMBIE_SLAYER_TIER_3:
                    return QuestType.ZOMBIE_SLAYER_TIER_3;
                case ZOMBIE_SLAYER_TIER_4:
                    return QuestType.ZOMBIE_SLAYER_TIER_4;
                case ZOMBIE_SLAYER_TIER_5:
                    return QuestType.ZOMBIE_SLAYER_TIER_5;

                case SPIDER_SLAYER_TIER_1:
                    return QuestType.SPIDER_SLAYER_TIER_1;
                case SPIDER_SLAYER_TIER_2:
                    return QuestType.SPIDER_SLAYER_TIER_2;
                case SPIDER_SLAYER_TIER_3:
                    return QuestType.SPIDER_SLAYER_TIER_3;
                case SPIDER_SLAYER_TIER_4:
                    return QuestType.SPIDER_SLAYER_TIER_4;

                case WOLF_SLAYER_TIER_1:
                    return QuestType.WOLF_SLAYER_TIER_1;
                case WOLF_SLAYER_TIER_2:
                    return QuestType.WOLF_SLAYER_TIER_2;
                case WOLF_SLAYER_TIER_3:
                    return QuestType.WOLF_SLAYER_TIER_3;
                case WOLF_SLAYER_TIER_4:
                    return QuestType.WOLF_SLAYER_TIER_4;

                case ENDERMAN_SLAYER_TIER_1:
                    return QuestType.ENDERMAN_SLAYER_TIER_1;
                case ENDERMAN_SLAYER_TIER_2:
                    return QuestType.ENDERMAN_SLAYER_TIER_2;
                case ENDERMAN_SLAYER_TIER_3:
                    return QuestType.ENDERMAN_SLAYER_TIER_3;
                case ENDERMAN_SLAYER_TIER_4:
                    return QuestType.ENDERMAN_SLAYER_TIER_4;

                case BLAZE_SLAYER_TIER_1:
                    return QuestType.BLAZE_SLAYER_TIER_1;
                case BLAZE_SLAYER_TIER_2:
                    return QuestType.BLAZE_SLAYER_TIER_2;
                case BLAZE_SLAYER_TIER_3:
                    return QuestType.BLAZE_SLAYER_TIER_3;
                case BLAZE_SLAYER_TIER_4:
                    return QuestType.BLAZE_SLAYER_TIER_4;
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     *
     * @param player the player whos quest you want to cancel
     */
    public static void cancelQuest(Player player) {
        quest.remove(player.getUniqueId());
        EntityDeathEvent.combat_exp.remove(player.getUniqueId());

        fightingBoss.remove(player.getUniqueId());
        ZombieSlayerBoss.bossMap.remove(player.getUniqueId());
    }
}
