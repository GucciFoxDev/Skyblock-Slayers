package com.guccifox.slayers.leveling;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.utilities.Utilities;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.text.NumberFormat;

public class EndermanSlayerLevelManager {

    @Getter @Setter private int level;
    @Getter @Setter private int xp;
    public int maxLevel = 9;

    /**
     *
     * @param level the level of the enderman slayer
     * @param xp amount of xp
     */
    public EndermanSlayerLevelManager(int level, int xp) {
        this.level = level;
        this.xp = xp;
    }

    /**
     *
     * @return get the next enderman level for the player
     */
    public int getNextLevel() {
        return level+1;
    }

    /**
     *
     * @return get the next levels xp (formatted and string)
     */
    public String getNextLevelXp() {
        int nextLevelXp = Slayers.getPlugin().getConfig().getInt("Enderman.Levels." + getNextLevel() + ".xp");
        if (nextLevelXp < 1000) {
            return Integer.toString(nextLevelXp);
        } else {
            return Utilities.formatValue(nextLevelXp);
        }
    }

    /**
     *
     * @return get the next levels xp (int)
     */
    public int getNextLevelXpInt() {
        return Slayers.getPlugin().getConfig().getInt("Enderman.Levels." + getNextLevel() + ".xp");
    }

    /**
     *
     * @return get the amount of xp till the next level
     */
    public String getXpTillNextLevel() {
        int xpTillNextLevel = Slayers.getPlugin().getConfig().getInt("Enderman.Levels." + getNextLevel() + ".xp") - xp;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(xpTillNextLevel);
    }

    /**
     *
     * @return get the progress bar for enderman
     */
    public String getProgressBar() {
        float percent = (float) getXp() / getNextLevelXpInt();
        int progressBars = (int) (20 * percent);

        return StringUtils.repeat(ChatColor.DARK_PURPLE + "-", progressBars)
                + StringUtils.repeat(ChatColor.WHITE + "-", 20 - progressBars);
    }

    /**
     *
     * @return get the players formatted xp
     */
    public String getFormattedXp() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(xp);
    }

    /**
     *
     * @return max level for enderman slayers
     */
    public int getMaxLevel() {
        return maxLevel;
    }
}
